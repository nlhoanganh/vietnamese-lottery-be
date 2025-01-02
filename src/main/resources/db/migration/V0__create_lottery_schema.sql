CREATE TABLE `channel` (
                           `id` integer PRIMARY KEY,
                           `name` varchar(50),
                           `region` varchar(2)
);

CREATE TABLE `lottery_result` (
                                  `id` integer PRIMARY KEY,
                                  `created_at` timestamp,
                                  `channel_id` integer
);

CREATE TABLE `lottery_number` (
                                  `id` integer,
                                  `result` varchar(10),
                                  `prize_id` integer,
                                  `lottery_result_id` integer
);

CREATE TABLE `prize` (
                         `id` integer PRIMARY KEY,
                         `name` varchar(2),
                         `value` integer,
                         `type` varchar(2),
                         `description` varchar(50)
);

ALTER TABLE `lottery_result` ADD FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`);

ALTER TABLE `lottery_number` ADD FOREIGN KEY (`lottery_result_id`) REFERENCES `lottery_result` (`id`);

ALTER TABLE `lottery_number` ADD FOREIGN KEY (`prize_id`) REFERENCES `prize` (`id`);