//Giải pháp 1: Constructor Injection
//Đây là cách tiêm phụ thuộc thông qua hàm khởi tạo của Class.
//Tính an toàn: Đảm bảo các phụ thuộc (EmailSender, SmsSender) không bao giờ ở trạng thái null khi service hoạt động.
//Tính bất biến: Cho phép khai báo các biến phụ thuộc là final, giúp ngăn chặn việc thay đổi nhầm đối tượng trong quá trình thực thi.
//Khả năng kiểm thử: Rất dễ dàng trong Unit Test vì bạn có thể tự tay truyền các đối tượng
//giả (Mock) vào mà không cần khởi động toàn bộ khung phần mềm (Spring Context).
//Độ minh bạch: Chỉ cần nhìn vào Constructor là biết ngay Service này cần những gì để chạy, không giấu giếm phụ thuộc.
//Xử lý lỗi mạng: Khi mạng SMS bị đứt, vì đối tượng SmsSender đã được khởi tạo chắc chắn,
// bạn có thể viết code xử lý lỗi tập trung mà không sợ lỗi hệ thống phát sinh từ việc thiếu đối tượng.
//
// 2. Giải pháp 2: Field Injection (Sử dụng @Autowired lên biến)
//Đây là cách tiêm trực tiếp vào các biến thành viên của Class.
//Tính tiện dụng: Code trông cực kỳ ngắn gọn, không cần viết hàm khởi tạo hay setter.
//Tính đóng gói: Vi phạm nguyên tắc đóng gói vì buộc phải sử dụng cơ chế phản xạ (Reflection) để can thiệp vào các biến private.
//Khả năng kiểm thử: Khó khăn hơn vì nếu không dùng Spring, bạn không có cách nào trực tiếp đưa đối tượng Mock vào các biến private này.
//Rủi ro Runtime: Có khả năng xảy ra lỗi NullPointerException nếu quá trình khởi tạo của Spring gặp vấn đề
// mà bạn chưa kịp phát hiện ở bước biên dịch.
//Xử lý lỗi mạng: Trong tình huống kết nối SMS chập chờn, việc phụ thuộc hoàn toàn vào cơ chế tiêm "ngầm" khiến việc
//kiểm soát vòng đời của đối tượng trở nên khó khăn hơn khi cần debug sâu.

//Chốt Lựa Chọn: Constructor Injection