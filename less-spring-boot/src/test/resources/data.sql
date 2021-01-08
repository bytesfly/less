INSERT INTO `tb_book`(`book_id`, `book_name`, `author`) VALUES (1, '多情剑客无情剑', '古龙');
INSERT INTO `tb_book`(`book_id`, `book_name`, `author`) VALUES (2, '笑傲江湖', '金庸');
INSERT INTO `tb_book`(`book_id`, `book_name`, `author`) VALUES (3, '倚天屠龙记', '金庸');
INSERT INTO `tb_book`(`book_id`, `book_name`, `author`) VALUES (4, '射雕英雄传', '金庸');
INSERT INTO `tb_book`(`book_id`, `book_name`, `author`) VALUES (5, '绝代双骄', '古龙');

INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (1, '李寻欢', '小李飞刀', 1);
INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (2, '令狐冲', '独孤九剑', 2);
INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (3, '张无忌', '九阳神功', 3);
INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (4, '郭靖', '降龙十八掌', 4);
INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (5, '花无缺', '移花接玉', 5);
INSERT INTO `tb_hero`(`hero_id`, `hero_name`, `skill`, `book_id`) VALUES (6, '任我行', '吸星大法', 2);

INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (1, 1, '小李飞刀，例无虚发，夺魂索命，弹指之间');
INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (2, 2, '令狐少侠留步!');
INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (3, 3, '尝遍世间善恶，归来仍是少年');
INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (4, 4, '我只要我的靖哥哥!');
INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (5, 5, '风采儒雅亦坦荡，武艺精深兼明智。');
INSERT INTO `tb_book_hero`(`book_id`, `hero_id`, `user_comment`) VALUES (2, 6, '有人就有恩怨，有恩怨就有江湖，人心即是江湖，你如何退出！');