create table tb_tasks(
    id_task bigint primary key auto_increment,
    title varchar(255),
    description varchar(255),
    is_completed boolean,
    creation_date date
)