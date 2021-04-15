# Thiết kế database

### Database diagram

![image](database-diagram.png)

### Chi tiết thiết kế

#### Task

| Name  |  Column         |  Type   |  Nullable | Default       |   Example      |  Comments   |            
|-------|-----------------|---------|-----------|---------------|----------------|-------------|
| Tasks | id              | Int     |  false    | auto increment| Primary Key    | PRIMARY KEY |
| Tasks | cat_id          | Int     |  true     |               | Cat Id         |             |
| Tasks | name            | String  |  false    |               | Task Name      |             |
| Tasks | finished        | Boolean |  false    |               | Is Finished    |             |
| Tasks | date            | Date    |  true     |               | Deadline Date  |             |
| Tasks | myDay           | Boolean |  false    |               | My Day         |             |
| Tasks | important       | Boolean |  false    |               | Important      |             |
| Tasks | reminder        | Date    |  true     |               | Reminder       |             |
| Tasks | repeat          | Date    |  true     |               | Repeat         |             |
| Tasks | createdAt       | Date    |  false    |               | Created At     |             |
| Tasks | note            | String  |  true     |               | Note           |             |

