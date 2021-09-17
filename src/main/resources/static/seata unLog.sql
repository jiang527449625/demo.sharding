-- Create table
create table UNDO_LOG
(
  id            NUMBER not null,
  branch_id     NUMBER,
  xid           VARCHAR2(100),
  context       VARCHAR2(128),
  rollback_info BLOB,
  log_status    NUMBER,
  log_created   DATE,
  log_modified  DATE
)
tablespace ZHIYDBA_TAB
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table UNDO_LOG
  add constraint PK_UNDO_LOG_ID primary key (ID)
  using index 
  tablespace ZHIYDBA_TAB
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate indexes 
create unique index UX_UNDO_LOG on UNDO_LOG (XID, BRANCH_ID)
  tablespace ZHIYDBA_TAB
  pctfree 10
  initrans 2
  maxtrans 255;