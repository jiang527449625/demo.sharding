-- Create table
create table course_1
(
    cid     varchar2(64),
    cname   varchar2(20),
    user_id varchar2(64),
    cstatus varchar2(20),
    year    date
)
;
-- Create/Recreate primary, unique and foreign key constraints
alter table course_1
    add constraint pk_course_1_cid primary key (CID);

-- Create table
create table course_2
(
    cid     varchar2(64),
    cname   varchar2(20),
    user_id varchar2(64),
    cstatus varchar2(20),
    year    date
)
;
-- Create/Recreate primary, unique and foreign key constraints
alter table course_2
    add constraint pk_course_2_cid primary key (CID);