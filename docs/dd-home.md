# Trang chủ

![Home page](home.png)

| # | Thành phần         |   Loại               | Chức năng          | Dữ liệu|
|---|--------------------|----------------------|--------------------|------------------------------|
| 1 | Ngày của tôi       |Nhóm theo thuộc tính  |Nhóm các nhiệm vụ được đánh dấú cần quan tâm ngày hôm nay.<br>https://fonts.google.com/icons?selected=Material%20Icons%3Alight_mode| count(task#is_my_day = true)|
| 2 | Quan trọng         |Nhóm theo thuộc tính  |Nhóm các nhiệm vụ được đánh dấu là quan trọng. icon: <br>https://fonts.google.com/icons?selected=Material%20Icons%3Astar_border| count(task#is_important = true)|
| 3 | Đã lập kế hoạch    |Nhóm theo thuộc tính  |Nhóm các nhiệm vụ đã được lập kế hoạch.<br>https://fonts.google.com/icons?selected=Material%20Icons%3Aevent_note| update(task#deadline=Date)|
| 4 | Tác vụ             |Nhóm theo thuộc tính  |Nhóm các nhiệm vụ được được thêm vào để giải quyết. <br>https://fonts.google.com/icons?selected=Material%20Icons%3Ahome| update(task)|
| 5 | Danh sách mới      | Button |Thêm nhiệm vụ vào danh sách các nhiệm vụ mới.     | update(new_task)|
| 7 | Danh sách nhiệm vụ | Listview             |Hiển thị các nhiệm vụ mới.<br>https://fonts.google.com/icons?selected=Material%20Icons%3Atoc       | update(list_new_task)|
| 8 | Số lượng           | TextView             |Hiển thị số lượng nhiệm vụ của mỗi thành phần. | count(task#task = 0)|
|9  | Nhóm nhiệm vụ      | Nhóm theo thuộc tính |Hiển thị nhiệm vụ mới được thêm vào danh sách nhiệm vụ mới.<br>https://fonts.google.com/icons?selected=Material Icons%3Atoc| update(new_task)|