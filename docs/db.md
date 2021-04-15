# Thiết kế database

### Database diagram

![image](database-diagram.png)

### Chi tiết thiết kế

#### Task

| Name  |  Column         |  Type   |  Nullable | Default       |   Example  |  Comments   |            
|-------|-----------------|---------|-----------|---------------|----------------|-------------|
| Tasks | id              | Int     |  false    | auto increment| Primary Key    | PRIMARY KEY |
| Tasks | cat_id          | Int     |  true     |               | Cat Id         |             |
| Tasks | name            | String  |  false    |               | Task Name      |             |
| Tasks | finished        | Boolean |  false    |               | Is Finished    |             |
| Tasks | deadline        | Date    |  true     |               | Deadline Date  |             |
| Tasks | my_day          | Boolean |  false    |               | My Day         |             |
| Tasks | important       | Boolean |  false    |               | Important      |             |
| Tasks | reminder        | Date    |  true     |               | Reminder       |             |
| Tasks | repeat          | Int     |  true     |               | Repeat         |             |
| Tasks | created_at      | Date    |  false    |               | Created At     |             |
| Tasks | note            | String  |  true     |               | Note           |             |

##### Mô tả

repeat:
Lưu các giá trị:
* 0: lặp lại mỗi ngày
* 1: lặp lại mỗi tuần
* 2: lặp lại mỗi tháng
* 3: lặp lại mỗi năm
