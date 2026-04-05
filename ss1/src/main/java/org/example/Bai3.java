//Dữ liệu đầu vào (Input)
//Hệ thống cần nhận các thông tin sau từ phía khách hàng (Client):
//username: Tên tài khoản người dùng đang ngồi tại máy trạm.
//foodName: Tên món ăn khách muốn gọi (Ví dụ: "Mì xào bò").
//quantity: Số lượng món ăn (Phải là số nguyên dương).
//Ví dụ: username = "nguyenvana", foodName = "Bún bò", quantity = 1.
//Kết quả mong đợi (Output)
//Kết quả trả về sau khi xử lý qua OrderFoodService cần thể hiện rõ:
//Trạng thái: Đặt món thành công hay thất bại.
//Lý do cụ thể nếu thất bại (Hết hàng, thiếu tiền, lỗi dữ liệu...).
//Thông số tài chính: Số tiền đã trừ và số dư còn lại sau giao dịch.
//Thông số kho: Số lượng món còn lại trong kho sau khi xuất.
//Ví dụ thành công:
//Trạng thái: Đặt món thành công.
//Chi tiết: Món: Bún bò | Số lượng: 1.
//Tài chính: Đã trừ 25.000đ | Số dư còn lại: 50.000đ.
//3. Phân tích các trường hợp lỗi (Bẫy dữ liệu)
//Hệ thống cần được thiết kế để "chặn" các tình huống dữ liệu bất thường thông qua InventoryRepository và UserAccountRepository:
//Trường hợp 1 (Kho trả về số lượng bằng 0):
//Truy vấn kho cho món "Bún bò" trả về stock = 0.
//Hành động: Dừng xử lý ngay, không trừ tiền, trả về: "Mì xào bò đã hết hàng".
//Trường hợp 2 (Số dư tài khoản âm):
//Truy vấn tài khoản trả về balance < 0 (Dữ liệu lỗi hệ thống).
//Hành động: Coi là lỗi logic, không thực hiện giao dịch, trả về: "Số dư tài khoản không hợp lệ".
//Trường hợp 3 (Số dư không đủ thanh toán):
//Tổng tiền đơn hàng > balance.
//Hành động: Từ chối đặt món, không trừ kho, trả về: "Tài khoản không đủ tiền".
//Trường hợp 4 (Món ăn không tồn tại):
//Không tìm thấy foodName trong database của InventoryRepository.
//Hành động: Báo lỗi "Món ăn không tồn tại", kết thúc xử lý.
//Trường hợp 5 (Số lượng gọi món không hợp lệ):
//Khách nhập quantity <= 0.
//Hành động: Báo lỗi "Số lượng gọi món phải lớn hơn 0".
//Các bước xử lý logic (Sequential Logic)
//Luồng nghiệp vụ được thực hiện tuần tự để đảm bảo tính Loose Coupling (thông qua Dependency Injection):
//Tiếp nhận yêu cầu: Nhận username, foodName, quantity từ máy trạm.
//Kiểm tra dữ liệu đầu vào (Validation):
//Đảm bảo username và foodName không rỗng.
//Kiểm tra quantity > 0.
//Kiểm tra kho (Inventory Check):
//Gọi InventoryRepository để lấy thông tin món ăn.
//Nếu không thấy món hoặc số lượng kho = 0: Trả về lỗi tương ứng và kết thúc.
//Kiểm tra nếu kho có đủ số lượng khách yêu cầu.
//
//Tính toán tài chính (Financial Calculation):
//
//Lấy đơn giá từ kho, tính: tổng tiền = giá * quantity.
//
//Gọi UserAccountRepository để lấy số dư của username.
//
//Kiểm tra điều kiện thanh toán:
//
//Nếu số dư âm: Trả về lỗi "Tài khoản không hợp lệ" và kết thúc.
//
//Nếu số dư < tổng tiền: Trả về lỗi "Không đủ tiền" và kết thúc.
//
//Thực thi giao dịch (Atomic Transaction):
//
//Trừ tiền trong tài khoản người dùng qua UserAccountRepository.
//
//Trừ số lượng tồn kho qua InventoryRepository.
//
//Phản hồi kết quả: Trả về thông báo thành công kèm biên lai chi tiết cho khách hàng.