# Thiết kế database

### Database diagram

![image](database-diagram.png)

### Chi tiết thiết kế

| Name  |  Column     |  Type   |  Nullable | Default |   Example      |  Comments   |            
|-------|-------------|---------|-----------|---------|----------------|-------------|
| Tasks | CateId      | Int     |  false    |         | Cate ID        |             |
| Tasks | TaskId      | Int     |  false    |         | Primary key    | PRIMARY KEY |
| Tasks | Name        | String  |  false    |         | Task Name      |             |
| Tasks | IsFinished  | Boolean |  false    |         | Is Finished    |             |
| Tasks | Date        | String  |  false    |         | Finished Date  |             |
| Tasks | IsMyday     | Boolean |  false    |         | My Day         |             |
| Tasks | IsImportant | Boolean |  false    |         | Important      |             |
| Tasks | IsReminder  | Boolean |  false    |         | Reminder       |             |
| Tasks | IsRepeat    | Boolean |  false    |         | Repeat         |             |
| Tasks | CreatedAt   | String  |  false    |         | Created At     |             |
| Tasks | Description | String  |  false    |         | Add Description|             |
>>>>>>> Update db.md
