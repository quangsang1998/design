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
| 8 | Ngày của tôi | TextView | Hiển thị ngày của tôi <br>Icon: ![myday](ic_myday.png)|select(task#myday) = true|
| 9 | Ngày đến hạn | TextView | Hiển thị đến hạn<br>Icon: ![deadline](ic_deadline.png) |select(task#deadline) = true|
| 10 | Icon lặp lại | ImageView | Hiển thị icon lặp lại<br>Icon: ![repeat](ic_repeat.png) |select(task#repeat) = true|
| 11 | Icon nhắc tôi | ImageView | Hiển thị icon nhắc tôi<br>Icon: ![notification](ic_notification.png) |select(task#reminder) = true|
| 12 | Nút thêm task | Floating Action Button | Thêm task vào màn hình |insert(task)|
| 13 | Đổi tên danh sách | MenuItem | Đổi tên danh sách<br>Icon: https://fonts.google.com/icons?selected=Material%20Icons%3Aedit|update(task#name)|
| 14 | Sắp xếp theo | MenuItem | Sắp xếp theo<br>Icon: https://fonts.google.com/icons?selected=Material%20Icons%3Asort ||
| 15 | Sắp xếp theo/ Tầm quan trọng| MenuItem | Sắp xếp theo tầm quan trọng<br>Icon: https://fonts.google.com/icons?selected=Material%20Icons%3Astar_outline |sort(task#important)|
| 16 | Sắp xếp theo/ Ngày đến hạn| MenuItem | Sắp xếp theo ngày đến hạn<br>Icon:https://fonts.google.com/icons?selected=Material%20Icons%3Acalendar_today |sort(task#deadline)|
| 17 | Sắp xếp theo/ Ngày của tôi| MenuItem | Sắp xếp theo đã thêm vào ngày của tôi<br>Icon: https://fonts.google.com/icons?selected=Material%20Icons%3Alight_mode |sort(task#myday)|
| 18 | Sắp xếp theo/ Thứ tự bảng chữ cái| MenuItem | Sắp xếp theo thứ tự bảng chữ cái<br>Icon: https://fonts.google.com/icons?selected=Material%20Icons%3Aswap_vert |sort(task#name)|
| 19 | Sắp xếp theo/ Ngày tạo| MenuItem | Sắp xếp theo ngày tạo<br>Icon:https://fonts.google.com/icons?selected=Material%20Icons%3Aadd_circle_outline |sort(task#created_at)|