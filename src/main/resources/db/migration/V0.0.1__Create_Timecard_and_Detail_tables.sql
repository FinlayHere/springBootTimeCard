create table time_card(
	`card_id` int not null auto_increment,
    `user_id` varchar(64) not null,
    `notes` varchar(128),
    constraint primary key(`card_id`)
);

create table timecard_detail(
	`detail_id` int not null auto_increment,
    `card_id` int not null,
    `project` varchar(128) not null,
    `sub_project` varchar(128) not null,
    `start_date` date not null,
    `location` varchar(64) not null,
    `Monday` int not null,
    `Tuesday` int not null,
    `Wednesday` int not null,
    `Thursday` int not null,
    `Friday` int not null,
    `Saturday` int not null,
    `Sunday` int not null,
    `billable` boolean not null,
    `comments` varchar(128) not null,
    constraint primary key(`detail_id`),
    foreign key(`card_id`) references time_card(`card_id`)
    ON DELETE CASCADE
);