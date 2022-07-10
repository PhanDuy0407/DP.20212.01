## Observable

  public abstract void addListener(javafx.beans.InvalidationListener arg0);

  public abstract void removeListener(javafx.beans.InvalidationListener arg0);

Ở đây Observable của javafx chỉ có 2 phương thức addListener và removeListener, không có phương thức notify

- An Observable là một thực thể bao bọc nội dung và cho phép quan sát nội dung để tìm những điểm không hợp lý.
- addListener:  Thêm một InvalidationListener sẽ được thông báo bất cứ khi nào Observable trở nên không hợp lệ. Nếu cùng Linstener nghe được thêm nhiều hơn một lần, thì nó sẽ được thông báo nhiều hơn một lần. Có nghĩa là, không có kiểm tra nào được thực hiện để đảm bảo tính duy nhất.
- removeListener: Loại bỏ trình nghe đã cho khỏi danh sách trình nghe, được thông báo bất cứ khi nào giá trị của giá trị Observabletrở nên không hợp lệ.
- 

So sánh với Observer mà mình đã học thì Observable ít hơn một phương thức, nghĩa là khi có bất kỳ một Linster nào bị lỗi thì lập tức Observable được gọi, còn Observer sẽ được gọi khi Data của mình được thay đổi 

Đối với việc sử dụng Observable trong code: Observable có thể được sử dụng để lắng nghe **InvalidationListener** Ví dụ như IOException để lắng nghe các lỗi và hiển thị