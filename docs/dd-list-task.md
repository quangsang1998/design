# Danh sách nhiệm vụ
# Ví dụ chi tiết thiết kế

![list](list.png)

| # | Thành phần | Loại | Chức năng | Dữ liệu |
| ---- | ---------- | ------------------- | --------- | --------- |
| 1 | Nút back| Button | Trở lại màn hình home<br>Icon: ![back](ic_arrow_back.png) |  |
| 2 | Icon của Category | ImageView | Hiển thị icon của Category<br>Icon: ![home](ic_home.png) |select(cat#icon)|
| 3 | Tên của Category | TextView | Hiển thị tên của Category |select(cat#name)|
| 4 | Nút more option | CreateOptionMenu | Hiển thị các thuộc tính cho task<br>Icon: ![more](ic_more.png) ||
| 5 | Nút hoàn thành | RadioButton | Hiển thị sự hoàn thành của task<br>Icon: ![radio button](ic_radio.png) |select(task#finished) = true|
| 6 | Tên task | TextView | Hiển thị tên của task|select(task#name)|
| 7 | Nút quan trọng | ImageView | Hiển thị độ quan trọng của task<br>Icon: ![important](ic_star.png) |select(task#important) = true|
| 10 | Icon ngày của tôi | ImageView | Hiển thị icon ngày của tôi<br>Icon: ![myday](ic_myday.png) |select(task#myday) = true|
| 8 | Ngày của tôi | TextView | Hiển thị ngày của tôi|select(task#myday) = true|
| 10 | Icon ngày đến hạn | ImageView | Hiển thị icon ngày đến hạn<br>Icon: ![deadline](ic_deadline.png) |select(task#deadline) = true|
| 9 | Ngày đến hạn | TextView | Hiển thị đến hạn |select(task#deadline) = true|
| 10 | Icon lặp lại | ImageView | Hiển thị icon lặp lại<br>Icon: ![repeat](ic_repeat.png) |select(task#repeat) = true|
| 11 | Icon nhắc tôi | ImageView | Hiển thị icon nhắc tôi<br>Icon: ![notification](ic_notification.png) |select(task#reminder) = true|
| 12 | Nút thêm task | Floating Action Button | Thêm task vào màn hình |insert(task)|