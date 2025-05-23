use cozy_haven;

-- User table
create table User (
    user_id int primary key auto_increment,
    first_name varchar(50) not null,
	middle_name varchar(50),
	last_name varchar(50) not null,
    email varchar(100) unique not null,
    password varchar(8) not null,
    gender varchar(15),
    contact_number varchar(15) not null,
    address text,
    role enum('user', 'admin', 'hotel_owner') not null,
    creation_date datetime default current_timestamp
);

-- Hotels table
create table Hotels (
    hotel_id int primary key auto_increment,
    hotel_name varchar(100) not null,
    location varchar(100),
    address text,
    contact_number varchar(15),
    description text
);

-- rooms table

create table Rooms (
    room_id int primary key auto_increment,
    hotel_id int not null,
    room_size varchar(50),
    bed_type enum('single', 'double', 'king') not null,
    base_fare decimal(10, 2) not null,
    max_persons int not null,
    is_ac boolean default true,
    status enum('available', 'unavailable') default 'available',
    created_at datetime default current_timestamp,
    foreign key (hotel_id) references hotels(hotel_id) on delete cascade
);

-- reservation table

create table Reservations (
    reservation_id int primary key auto_increment,
    user_id int not null,
    hotel_id int not null,
    room_id int not null,
    check_in_date date not null,
    check_out_date date not null,
    number_of_rooms int not null,
    number_of_adults int not null,
    number_of_children int not null,
    total_price decimal(10, 2) not null,
    status enum('booked', 'cancelled', 'refunded') default 'booked',
    creation_at datetime default current_timestamp,
    foreign key (user_id) references users(user_id) on delete cascade,
    foreign key (hotel_id) references hotels(hotel_id) on delete cascade,
    foreign key (room_id) references rooms(room_id) on delete cascade
);

-- reservation_guests table

create table reservation_guests (
    guest_id int primary key auto_increment,
    reservation_id int not null,
    guest_name varchar(100) not null,
    age int,
    gender varchar(10),
    is_primary_guest boolean default false,
    foreign key (reservation_id) references reservations(reservation_id) on delete cascade
);

-- payments table

create table Payments (
    payment_id int primary key auto_increment,
    reservation_id int not null,
    payment_date datetime default current_timestamp,
    amount decimal(10, 2) not null,
    payment_method enum('card', 'upi', 'net_banking') not null,
    payment_status enum('success', 'failed', 'refunded') not null,
    foreign key (reservation_id) references reservations(reservation_id) on delete cascade
);

-- reviews table

create table Reviews (
    review_id int primary key auto_increment,
    user_id int not null,
    hotel_id int not null,
    rating int check (rating between 1 and 5),
    comment text,
    created_at datetime default current_timestamp,
    foreign key (user_id) references users(user_id) on delete cascade,
    foreign key (hotel_id) references hotels(hotel_id) on delete cascade
);

-- refunds table
create table refunds (
    refund_id int primary key auto_increment,
    reservation_id int not null,
    refund_amount decimal(10, 2) not null,
    refund_reason text,
    refund_date datetime default current_timestamp,
    refund_guest_id int,
    foreign key (reservation_id) references reservations(reservation_id) on delete cascade,
    foreign key (refund_guest_id) references users(user_id)
);