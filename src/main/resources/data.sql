INSERT INTO users(create_by, create_date, modified_by, modified_date, address, data_of_birth, email, full_name, gender,
                  image, is_verified, password, phone, status)
VALUES ('user', '2024-01-22', NULL, NULL, 'vinhome quan 9', '2024-01-22', 'phumap942002@gmail.com', 'duong minh phu',
        'nam', NULL, true, '123456', '0786999528', true),
       ('user1', '2024-01-22', NULL, NULL, 'thu duc', '2024-01-22', 'longan@gmail.com', 'nguyen long an ', 'nam ', NULL,
        true, '123', '0912213212', true),
       ('user2', '2024-01-22', NULL, NULL, 'binh duong', '2024-01-22', 'hieu@gmail.com', 'nguyen minh hieu', 'nam ',
        NULL, true, '123', '0123244555', true),
       ('user3', '2024-01-22', NULL, NULL, 'dong nai', '2024-01-22', 'thangla@gmail.com', 'nguyen minh thang ', 'nam',
        NULL, true, '123', '0213123923', true),
       ('user4', '2024-01-22', NULL, NULL, 'vung tau', '2024-01-22', 'kienq7@gmail.com', 'nguyen trung kien ', 'nam ',
        NULL, true, '123', '0912353451', true),
       ('user5', '2024-01-22', NULL, NULL, 'lam dong ', '2024-01-22', 'nam@gmail.com', 'tran pham thanh nam ', 'nam',
        NULL, true, '123', '0873232338', true),
       ('user6', '2024-01-22', NULL, NULL, 'vinh long', '2024-01-22', 'phat@gmail.com', 'nguyen tien phat', 'nam', NULL,
        true, '123', '0923881391', true),
       ('user7', '2024-01-22', NULL, NULL, 'long tam ', '2024-01-22', 'tam@gmail.com', 'nguyen minh tam', 'nam', NULL, true,
        '123', '0231893131', true),
       ('user8', '2024-01-22', NULL, NULL, 'long phuoc', '2024-01-22', 'phuoc@gmail.com', 'phan tan phuoc', 'nam', NULL,
        true, '123', '0412939121', true),
       ('user9', '2024-01-22', NULL, NULL, 'phu my', '2024-01-22', 'my@gmail.com', 'nguyen thi kim my', 'nu', NULL, false,
        '123', '0912325341', false),
       ('user10', '2024-01-22', NULL, NULL, 'tan binh', '2024-01-22', 'binh@gmail.com', 'kim binh mai', 'nu', NULL, true,
        '123', '0934234234', true);

INSERT INTO area(create_by, create_date, modified_by, modified_date, name,status)
VALUES ('long', '2024-01-22', NULL, NULL, 'long',true),
       ('phat', '2024-01-22', NULL, NULL, 'phat',true),
       ('hieu', '2024-01-22', NULL, NULL, 'S203',true),
       ('thang', '2024-01-22', NULL, NULL, 'S202',true),
       ('nam', '2024-01-22', NULL, NULL, 'S201',true);

INSERT INTO zone(create_by, create_date, modified_by, modified_date, name, area_id,status)
VALUES ('long', '2024-01-22', NULL, NULL, 'long', 1,true),
       ('phat', '2024-01-22', NULL, NULL, 'phat', 2,true),
       ('hieu', '2024-01-22', NULL, NULL, 'hieu', 3,true),
       ('thang','2024-01-22', NULL, NULL, 'thang', 4,true),
       ('nam',  '2024-01-22', NULL, NULL, 'nam', 5,true);

INSERT INTO building(create_by, create_date, modified_by, modified_date, name, zone,status)
VALUES ('long ', '2024-01-22', NULL, NULL, 'long', 1,true),
       ('phat', '2024-01-22', NULL, NULL, 'phat', 2,true),
       ('hieu', '2024-01-22', NULL, NULL, 'hieu', 3,true),
       ('thang', '2024-01-22', NULL, NULL, 'thang', 4,true),
       ('nam', '2024-01-22', NULL, NULL, 'nam', 5,true);

INSERT INTO apartment(create_by, create_date, modified_by, modified_date, air_conditioner, area, bed_room, description,
                      electric_fan, electric_stoves, floor, gas_stoves, kitchen, living_room, name, rest_room, status,
                      television, building_id)
VALUES ('LA', '2024-01-22', NULL, NULL, 2, 48, 2, 'nha dep nhat vi', 1, 0, 3, 1, 1, 1, '0611', 3, true, 3, 1),
       ('thang', '2024-01-22', NULL, NULL, 3, 50, 2, 'xin nhat ', 2, 0, 4, 2, 3, 2, '0612', 3, true, 4, 1),
       ('phat', '2024-01-22', NULL, NULL, 3, 60, 3, 'nha dinh nhat', 3, 0, 4, 3, 2, 2, '0613', 3, true, 2, 2),
       ('phat', '2024-01-22', NULL, NULL, 2, 55, 3, 'view dep nhat', 3, 0, 5, 2, 2, 4, '0614', 3, true, 4, 2),
       ('nam', '2024-01-22', NULL, NULL, 3, 45, 1, 'nha bth', 1, 1, 3, 1, 1, 1, '0615', 1, false, 1, 3),
       ('hieu', '2024-01-22', NULL, NULL, 3, 48, 2, 'nha nho', 1, 1, 3, 2, 1, 1, '0616', 2, false, 1, 3),
       ('hieu', '2024-01-22', NULL, NULL, 3, 50, 2, '2 p', 1, 2, 5, 2, 1, 1, '0610', 2, true, 3, 4),
       ('minh', '2024-01-22', NULL, NULL, 3, 50, 2, 'phong big', 1, 2, 3, 2, 1, 1, '0609', 2, true, 2, 2),
       ('minh', '2024-01-22', NULL, NULL, 3, 50, 2, 'small', 1, 2, 3, 2, 1, 1, '0608', 2, true, 3, 3);

INSERT INTO appointment(create_by, create_date, modified_by, modified_date, date_time, status_appointment, apartment_id, user_id,status)
VALUES ('thang', '2024-01-22', NULL, NULL,
        '2024-01-22', 'Access', 1, 8,true),
       ('nam', '2024-01-22', NULL, NULL,
        '2024-01-22', 'Access', 2, 9,true),
       ('hieu', '2024-01-22', NULL, NULL,
        '2024-01-22', 'Access', 3, 8,true),
       ('phu', '2024-01-22', NULL, NULL,
        '2024-01-22', 'Finished', 4, 7,true),
       ('kie', '2024-01-22', NULL, NULL,
        '2024-01-22','Cancel', 5, 6,true),
       ('minh', '2024-01-22', NULL, NULL,
        '2024-01-22', 'Pending', 6, 5,true);

INSERT INTO contract_history(create_by, create_date, modified_by, modified_date, description, expired_time, image,
                             price, status, user_id)
VALUES ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 22020, true, 1),
       ('abc', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 5050505, true, 2),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 84834, true, 3),
       ('abc', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 234234, true, 4),
       ('abc', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 665675, true, 5),
       ('abc', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 4664654, false, 7),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 65353, false, 8),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 2452453445, false, 9),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 23423432, false, 10),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 3544534453, false, 1),
       ('xyz', '2024-01-22', NULL, NULL, NULL, NULL, NULL, 24324234, false, 4);

INSERT INTO contract(create_by, create_date, modified_by, modified_date, date_sign, date_start_rent, description,
                     status, contract_id)
VALUES ('Người tạo 1', '2024-01-22', 'Người sửa đổi 1', '2024-01-22', '2024-01-21', '2024-02-01', 'Mô tả hợp đồng 1',
        true, 1),
       ('Người tạo 2', '2024-01-22', 'Người sửa đổi 2', '2024-01-22', '2024-01-22', '2024-02-15', 'Mô tả hợp đồng 2',
        false, 2),
       ('Người tạo 3', '2024-01-22', 'Người sửa đổi 3', '2024-01-22', '2024-01-23', '2024-03-01', 'Mô tả hợp đồng 3',
        true, 3),
       ('Người tạo 4', '2024-01-22', 'Người sửa đổi 4', '2024-01-22', '2024-01-24', '2024-04-01', 'Mô tả hợp đồng 4',
        false, 4),
       ('Người tạo 5', '2024-01-22', 'Người sửa đổi 5', '2024-01-22', '2024-01-25', '2024-05-01', 'Mô tả hợp đồng 5',
        true, 5),
       ('Người tạo 6', '2024-01-22', 'Người sửa đổi 6', '2024-01-22', '2024-01-26', '2024-06-01', 'Mô tả hợp đồng 6',
        false, 6),
       ('Người tạo 7', '2024-01-22', 'Người sửa đổi 7', '2024-01-22', '2024-01-27', '2024-07-01', 'Mô tả hợp đồng 7',
        true, 7),
       ('Người tạo 8', '2024-01-22', 'Người sửa đổi 8', '2024-01-22', '2024-01-28', '2024-08-01', 'Mô tả hợp đồng 8',
        false, 8),
       ('Người tạo 9', '2024-01-22', 'Người sửa đổi 9', '2024-01-22', '2024-01-29', '2024-09-01', 'Mô tả hợp đồng 9',
        true, 9),
       ('Người tạo 10', '2024-01-22', 'Người sửa đổi 10', '2024-01-22', '2024-01-30', '2024-10-01', 'Mô tả hợp đồng 10',
        false, 10);

INSERT INTO notification_type(create_by, create_date, modified_by, modified_date, name, status)
VALUES (NULL, '2024-01-22', NULL, NULL, 'long', true),
       (NULL, '2024-01-22', NULL, NULL, 'nhat', false),
       ('a', '2024-01-22', NULL, NULL, 'a', true),
       ('nhat long', '2024-01-22', NULL, NULL, 'thanh', true),
       ('nhat long', '2024-01-22', NULL, NULL, 'nhat', false),
       ('nhat long', '2024-01-22', NULL, NULL, 'hieu', true);

INSERT INTO notifications(create_by, create_date, modified_by, modified_date, context, is_read, time, tittle, user_id)
VALUES ('Người tạo 1', '2024-01-22', 'Người sửa đổi 1', '2024-01-22', 'Mô tả bài viết 1',true,'11:30:00', 'Tiêu đề bài viết 1', 1),
       ('Người tạo 2', '2024-01-22', 'Người sửa đổi 2', '2024-01-22', 'Mô tả bài viết 2',true,'11:30:00', 'Tiêu đề bài viết 2', 2),
       ('Người tạo 3', '2024-01-22', 'Người sửa đổi 3', '2024-01-22', 'Mô tả bài viết 3',true,'11:30:00', 'Tiêu đề bài viết 3', 3),
       ('Người tạo 4', '2024-01-22', 'Người sửa đổi 4', '2024-01-22', 'Mô tả bài viết 4',true,'11:30:00', 'Tiêu đề bài viết 4', 4),
       ('Người tạo 5', '2024-01-22', 'Người sửa đổi 5', '2024-01-22', 'Mô tả bài viết 5',false,'11:30:00', 'Tiêu đề bài viết 5', 5),
       ('Người tạo 6', '2024-01-22', 'Người sửa đổi 6', '2024-01-22', 'Mô tả bài viết 6',false,'11:30:00', 'Tiêu đề bài viết 6', 6),
       ('Người tạo 7', '2024-01-22', 'Người sửa đổi 7', '2024-01-22', 'Mô tả bài viết 7',true,'11:30:00', 'Tiêu đề bài viết 7', 7),
       ('Người tạo 8', '2024-01-22', 'Người sửa đổi 8', '2024-01-22', 'Mô tả bài viết 8',false,'11:30:00', 'Tiêu đề bài viết 8', 8),
       ('Người tạo 9', '2024-01-22', 'Người sửa đổi 9', '2024-01-22', 'Mô tả bài viết 9',false,'11:30:00', 'Tiêu đề bài viết 9', 9);

INSERT INTO notification_notification_type(notification_id, notification_type_id)
VALUES (1, 1),
       (1, 4),
       (1, 5),
       (2, 5),
       (4, 4);

INSERT INTO post(create_by, create_date, modified_by, modified_date, description, title, apartment_id)
VALUES ('long', '2024-01-22', NULL, NULL, 'cho thue nha', 'qua dinh', 1),
       ('nhat', '2024-01-22', NULL, NULL, 'dinh', '10 diem ', 2),
       ('hieu', '2024-01-22', NULL, NULL, 'can cho thue', 'thue', 3),
       ('a', '2024-01-22', NULL, NULL, 'can cho thue', 'thue', 4),
       ('long', '2024-01-22', NULL, NULL, 'cho thue ne', 'thue', 5),
       ('kie', '2024-01-22', NULL, NULL, NULL, 'thue 1 thang', 6),
       ('thang', '2024-01-22', NULL, NULL, NULL, 'thue 2 thang', 7),
       ('namm', '2024-01-22', NULL, NULL, NULL, 'thue 3 thang', 8),
       ('minh', '2024-01-22', NULL, NULL, NULL, 'thue 4 thang', 8);

INSERT INTO post_image(create_by, create_date, modified_by, modified_date, image_alt, image_url, post_id)
VALUES ('long', '2024-01-22', NULL, NULL, NULL, NULL, 1),
       ('nam', '2024-01-22', NULL, NULL, NULL, NULL, 2),
       ('thang', '2024-01-22', NULL, NULL, NULL, NULL, 3),
       ('hoa', '2024-01-22', NULL, NULL, NULL, NULL, 4),
       ('kie', '2024-01-22', NULL, NULL, NULL, NULL, 5),
       ('trung', '2024-01-22', NULL, NULL, NULL, NULL, 6),
       ('hieu', '2024-01-22', NULL, NULL, NULL, NULL, 7),
       ('phu', '2024-01-22', NULL, NULL, NULL, NULL, 8),
       ('minh', '2024-01-22', NULL, NULL, NULL, NULL, 9);

INSERT INTO role(create_by, create_date, modified_by, modified_date, role, user_id)
VALUES ('user', '2024-01-22', NULL, NULL, 'ADMI', 1),
       ('user1', '2024-01-22', NULL, NULL, 'USER', 5),
       ('user2', '2024-01-22', NULL, NULL, 'USER', 6),
       ('user3', '2024-01-22', NULL, NULL, 'USER', 7),
       ('user4', '2024-01-22', NULL, NULL, 'USER', 8),
       ('user5', '2024-01-22', NULL, NULL, 'USER', 9);

INSERT INTO apartment_class(height, length, name, rent_price, width, apartment_id,status)
VALUES (300, 600, 'abc', 3000000000, 600, 1,true),
       (300, 500, 'xyz', 1500000000, 600, 2,true),
       (300, 700, 'nha ngo', 2000000000, 600, 3,true),
       (300, 550, 'nha xi', 2200000000, 700, 4,true),
       (300, 480, 'nha bth', 1800000000, 500, 5,true),
       (300, 500, 'nha nha nha', 2000000000, 600, 6,true),
       (300, 580, 'nha to ', 3400000000, 700, 7,true);

INSERT INTO issue(create_by, create_date, modified_by, modified_date, name, status, problems)
VALUES ('asss', '2024-01-22', NULL, NULL, 'nhat ', true, NULL),
       ('bsss', '2024-01-22', NULL, NULL, 'long', true, NULL),
       ('cssss', '2024-01-22', NULL, NULL, 'a', true, NULL),
       ('dsss', '2024-01-22', NULL, NULL, 'vu', false, NULL),
       ('iiii', '2024-01-22', NULL, NULL, 'huey', false, NULL),
       ('dfsdfsdf', '2024-01-22', NULL, NULL, 'minh',true, NULL),
       ('afasdfsadf', '2024-01-22', NULL, NULL, 'phu', true, NULL),
       ('asdfa', '2024-01-22', NULL, NULL, 'kie', false, NULL);

INSERT INTO payment(create_by, create_date, modified_by, modified_date, content, payment_time, total_price, contract_id,
                    payment_type_id)
VALUES ('aaa', '2024-01-22', NULL, NULL, NULL, NULL, 500, NULL, NULL),
       ('xxx', '2024-01-22', NULL, NULL, NULL, NULL, 600, NULL, NULL),
       ('zzz', '2024-01-22', NULL, NULL, NULL, NULL, 700, NULL, NULL),
       ('ccc', '2024-01-22', NULL, NULL, NULL, NULL, 800, NULL, NULL),
       ('qqq', '2024-01-22', NULL, NULL, NULL, NULL, 900, NULL, NULL),
       ('err', '2024-01-22', NULL, NULL, NULL, NULL, 100, NULL, NULL),
       ('ttt', '2024-01-22', NULL, NULL, NULL, NULL, 443, NULL, NULL),
       ('www', '2024-01-22', NULL, NULL, NULL, NULL, 8943, NULL, NULL);

INSERT INTO problems(create_by, create_date, modified_by, modified_date, description, status, title, contract_id)
VALUES ('xxx', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 1', 1),
       ('Nam đẹp trai', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 2', 2),
       ('yyyy', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', false, 'title 3', 3),
       ('hhh', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 4', 4),
       ('wqeqwe', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 5', 5),
       ('rqwerqwer', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 6', 6),
       ('afafasd', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 7', 7),
       ('fgdfgsd', '2024-01-22', NULL, NULL, 'Mô tả của Nam đẹp trai', true, 'title 8', 8);

INSERT INTO review(create_by, create_date, modified_by, modified_date, content, rate, apartment_id, user_id)
VALUES ('long', '2024-01-22', 'thang', '2024-01-22', 'danh gia', 4.5, 1, 2),
       ('Nam handsome', '2024-01-22', NULL, '2024-01-22', NULL, 5, 2, 5),
       ('Hieu handsome', '2024-01-22', NULL, '2024-01-22', NULL, 3, 3, 6),
       ('Phu handsome', '2024-01-22', NULL, '2024-01-22', NULL, 4, 4, 8),
       ('Kien handsome', '2024-01-22', NULL, '2024-01-22', NULL, 5, 5, 9),
       ('Thang amdi', '2024-01-22', NULL, '2024-01-22', NULL, 1, 7, 6),
       ('Minh LeeSin toc danh', '2024-01-22', NULL, '2024-01-22', NULL, 4, 6, 1);





