-- add developers
insert into issuetrackerdb.developers (name, version)
values ('test developer 1', 1);
insert into issuetrackerdb.developers (name, version)
values ('test developer 2', 1);
insert into issuetrackerdb.developers (name, version)
values ('test developer 3', 1);

-- add bugs
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (1, 'test bug 1', 'bug 1 description', '2016-09-03 00:00:00', 2, 1, 3, 1, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (2, 'test bug 2', 'bug 2 description', '2016-09-03 00:00:00', 1, 1, 2, 3, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (3, 'test bug 3', 'bug 3 description', '2016-09-03 00:00:00', 2, 1, 1, 2, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (4, 'test bug 4', 'bug 4 description', '2016-09-03 00:00:00', 1, 1, 2, 1, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (5, 'test bug 5', 'bug 5 description', '2016-09-03 00:00:00', 1, 1, 3, 3, null, 1);

-- add stories
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version, assigned_week)
values (6, 'test story 1', 'story 1 description', '2016-09-03 00:00:00', 1, 2, 3, null, 1, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version, assigned_week)
values (7, 'test story 2', 'story 2 description', '2016-09-03 00:00:00', 2, 2, 2, null, 2, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version, assigned_week)
values (8, 'test story 3', 'story 3 description', '2016-09-03 00:00:00', 3, 2, 2, null, 3, null, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (9, 'test story 4', 'story 4 description', '2016-09-03 00:00:00', null, 2, 2, null, 5, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (10, 'test story 5', 'story 5 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (11, 'test story 6', 'story 6 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (12, 'test story 7', 'story 7 description', '2016-09-03 00:00:00', null, 2, 2, null, 2, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (13, 'test story 8', 'story 8 description', '2016-09-03 00:00:00', null, 2, 2, null, 3, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (14, 'test story 9', 'story 9 description', '2016-09-03 00:00:00', null, 2, 2, null, 5, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (15, 'test story 10', 'story 10 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);


insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (16, 'test story 11', 'story 11 description', '2016-09-03 00:00:00', null, 2, 2, null, 1, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (17, 'test story 12', 'story 12 description', '2016-09-03 00:00:00', null, 2, 2, null, 2, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (18, 'test story 13', 'story 13 description', '2016-09-03 00:00:00', null, 2, 2, null, 3, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (19, 'test story 14', 'story 14 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (20, 'test story 15', 'story 15 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (21, 'test story 16', 'story 16 description', '2016-09-03 00:00:00', null, 2, 2, null, 1, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (22, 'test story 17', 'story 17 description', '2016-09-03 00:00:00', null, 2, 2, null, 2, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (23, 'test story 18', 'story 18 description', '2016-09-03 00:00:00', null, 2, 2, null, 2, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (24, 'test story 19', 'story 19 description', '2016-09-03 00:00:00', null, 2, 2, null, 5, 1);
insert into issuetrackerdb.issues (id, title, description, creation_date, developer_id, type, status, priority, point,
                                   version)
values (25, 'test story 20', 'story 20 description', '2016-09-03 00:00:00', null, 2, 2, null, 8, 1);


