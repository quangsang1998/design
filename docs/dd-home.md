# Trang chủ

![Home page](home.png)

| # | Thành phần         |   Loại               | Chức năng          | Dữ lieu|
|---|--------------------|----------------------|--------------------|------------------------------|
| 1 | Ngày của tôi       | Button               |Nhóm các nhiệm vụ được đánh dấú cần quan tâm ngày hôm nay. icon: abc.png| count(task#is_my_day = true)
| 2 | Quan trọng         | Button               |Nhóm các nhiệm vụ được đánh dấu là quan trọng. icon: i.png| count(task#is_important = true)
| 3 | Đã lập kế hoạch    | Button               |Nhóm các nhiệm vụ đã được lập kế hoạch. icon: p.png| update(task#deadline=Date)
| 4 | Tác vụ             | Button               |Nhóm các nhiệm vụ được được thêm vào để giải quyết. icon: t.png| update(task)
| 5 | Danh sách mới      | FloadingActionButton |Thêm nhiệm vụ vào danh sách các nhiệm vụ mới.     | update(new_task)
| 6 | Nhóm nhiệm vụ      | FloadingActionButton |Tạo nhóm cho các nhiệm vụ.| update(task_group)
| 6 | Danh sách nhiệm vụ | Listview             |Hiển thị các nhiệm vụ mới. icon: l.png            | update(list_new_task)
| 7 | Số lượng           | View                 |Hiển thị số lượng nhiệm vụ của mỗi thành phần. | count(task#task = 0)
| 8 | Icon               | ImageView            |Hiển thị icon cho các thành phần.| insert(icon)|