-- BOOKS

INSERT INTO book (book_id, name, system, acronym) VALUES (1, 'Core Rulebook', 1, 'CRB');
INSERT INTO book (book_id, name, system, acronym) VALUES (2, 'Game Master\'s Kit', 1, 'GMK');
INSERT INTO book (book_id, name, system, acronym) VALUES (3, 'Beyond the Rim', 1, 'BtR');
INSERT INTO book (book_id, name, system, acronym) VALUES (4, 'Enter the Unknown', 1, 'EtU');
INSERT INTO book (book_id, name, system, acronym) VALUES (5, 'Suns of Fortune', 1, 'SoF');
INSERT INTO book (book_id, name, system, acronym) VALUES (6, 'Jewel of Yavin', 1, 'JoY');
INSERT INTO book (book_id, name, system, acronym) VALUES (7, 'Dangerous Covenants', 1, 'DC');
INSERT INTO book (book_id, name, system, acronym) VALUES (8, 'Beginner Game - Adventure Book', 2, 'BGA');
INSERT INTO book (book_id, name, system, acronym) VALUES (9, 'Beginner Game - Rulebook', 2, 'BGR');
INSERT INTO book (book_id, name, system, acronym) VALUES (10, 'Operation Shadowpoint', 2, 'OS');
INSERT INTO book (book_id, name, system, acronym) VALUES (11, 'Core Rulebook', 2, 'CRB');
INSERT INTO book (book_id, name, system, acronym) VALUES (12, 'Dead in the Water', 2, 'DitW');
INSERT INTO book (book_id, name, system, acronym) VALUES (13, 'Far Horizons', 1, 'FH');
INSERT INTO book (book_id, name, system, acronym) VALUES (14, 'Onslaught at Arda I', 2, 'OaA');
INSERT INTO book (book_id, name, system, acronym) VALUES (15, 'Rescue at Glare Peak', 2, 'RaGP');
INSERT INTO book (book_id, name, system, acronym) VALUES (16, 'Scum and Villainy Adversary Deck', 0, 'SaVAD');
INSERT INTO book (book_id, name, system, acronym) VALUES (17, 'Imperials and Rebels Adversary Deck', 0, 'IaRAD');
INSERT INTO book (book_id, name, system, acronym) VALUES (18, 'Citizens of the Galaxy Adversary Deck', 0, 'CotGAD');
INSERT INTO book (book_id, name, system, acronym) VALUES (19, 'Stay on Target', 2, 'SoT');
INSERT INTO book (book_id, name, system, acronym) VALUES (20, 'Lords of Nal Hutta', 1, 'LoNH');
INSERT INTO book (book_id, name, system, acronym) VALUES (21, 'Fly Casual', 1, 'FC');
INSERT INTO book (book_id, name, system, acronym) VALUES (22, 'Desperate Allies', 2, 'DA');
INSERT INTO book (book_id, name, system, acronym) VALUES (23, 'Beginner Game - Adventure Book', 3, 'BGA');
INSERT INTO book (book_id, name, system, acronym) VALUES (24, 'Beginner Game - Rulebook', 3, 'BGR');
INSERT INTO book (book_id, name, system, acronym) VALUES (25, 'Core Rulebook', 3, 'CRB');
INSERT INTO book (book_id, name, system, acronym) VALUES (26, 'Chronicles of the Gatekeeper', 3, 'CotG');
INSERT INTO book (book_id, name, system, acronym) VALUES (27, 'Hidden Depths', 3, 'HD');
INSERT INTO book (book_id, name, system, acronym) VALUES (28, 'Mask of the Pirate Queen', 1, 'MPQ');
INSERT INTO book (book_id, name, system, acronym) VALUES (29, 'Strongholds of Resistance', 2, 'SoR');
INSERT INTO book (book_id, name, system, acronym) VALUES (30, 'Lead by Example', 2, 'LbE');
INSERT INTO book (book_id, name, system, acronym) VALUES (31, 'Keeping the Peace', 3, 'KtP');
INSERT INTO book (book_id, name, system, acronym) VALUES (32, 'Beginner Game - Rulebook', 1, 'BGR');
INSERT INTO book (book_id, name, system, acronym) VALUES (33, 'Beginner Game - Adventure Book', 1, 'BGA');
INSERT INTO book (book_id, name, system, acronym) VALUES (34, 'Nexus of Power', 3, 'NoP');
INSERT INTO book (book_id, name, system, acronym) VALUES (35, 'Special Modifications', 1, 'SM');
INSERT INTO book (book_id, name, system, acronym) VALUES (36, 'Savage Spirits', 3, 'SS');
INSERT INTO book (book_id, name, system, acronym) VALUES (37, 'Forged in Battle', 2, 'FiB');
INSERT INTO book (book_id, name, system, acronym) VALUES (38, 'Endless Vigil', 3, 'EV');
INSERT INTO book (book_id, name, system, acronym) VALUES (39, 'Friends Like These', 2, 'FLT');
INSERT INTO book (book_id, name, system, acronym) VALUES (40, 'No Disintegrations', 1, 'ND');
INSERT INTO book (book_id, name, system, acronym) VALUES (41, 'Disciples of Harmony', 3, 'DoH');
INSERT INTO book (book_id, name, system, acronym) VALUES (42, 'Ghosts of Dathomir', 3, 'GoD');
INSERT INTO book (book_id, name, system, acronym) VALUES (43, 'Fully Operational', 2, 'FO');

-- ////////////////////////ARCHIVE

INSERT INTO `role` (name) VALUES ('USER'), ('ADMIN');


INSERT INTO legends.user (username, character_service, has_authorities, starfish, password_confirm, password) VALUES
  ('Chuck', NULL, 0, '$2a$10$P7o1shjGMpkZC.U6BVDYuuZtF08P0BlZ60.I0HRzqB010ZgNdUrRG', 'SoapySucks',
   '87492901-bfb6-4606-8718-8cd182149a92');
INSERT INTO legends.user (username, character_service, has_authorities, starfish, password_confirm, password) VALUES
  ('GM', NULL, 0, '$2a$10$7hFbWnv8zCSfVwIJoVDj.O13zWbaalyJcQzM4Ze8pBPNxLtHSyIQW', 'ItsAllRigh!1',
   '419f8067-7444-4ea7-94e7-7b32b1fa69a3');


INSERT INTO legends.user_role (user_id, role_id) VALUES ('Chuck', 1);
INSERT INTO legends.user_role (user_id, role_id) VALUES ('GM', 1);
INSERT INTO legends.user_role (user_id, role_id) VALUES ('GM', 2);

/* SOAPY'S STUFF */
INSERT INTO legends.species (agility, brawn, cun, exp, intellect, presence, strain, will, wound, name)
VALUES (1, 1, 1, 175, 1, 1, 1, 1, 1, 'Droid');
INSERT INTO legends.user (username, character_service, has_authorities, starfish, password_confirm, password) VALUES
  ('Soappopotamus', NULL, 0, '$2a$10$JxHEX7a7k/JGhIMmCTHO2e6rl5YXwfEqoy9LQ74iea/B/7oxQpIPa', 'Abrakadabra1!',
   'f2f399b2-4074-4660-8221-742d5dd0849d');
INSERT INTO legends.user_role (user_id, role_id) VALUES ('Soappopotamus', 1);
INSERT INTO legends.user_character (age, agility, avatar, background, brawn, career, credits, cunning, current_strain, current_wounds, currentxp, defense, encumbrance, equipments, eyes, force_powers, gender, hair, hash_key, height, intellect, motivations, name, obligations, other, presence, soak, specialization, total_strain, total_wounds, totalxp, user_name, willpower, duty, morality)
VALUES
  (37, 3, 'http://empire-legends.herokuapp.com/public/gfx/pash.png', 'BACKGROUND', 2, 'Soldier', 1149, 1, 0, 0, 0, '0',
                                                                                                                   0, 'Riot PlayerArmorEntity (Built In) +2 Soak
Stimpack x2
Emergency Repair patch x2
Handheld Comlink (built in)
Med Pack', 'Yes', 0, 'Robit', 'Metal', '006', '6''6"', 3, 'Quest: Vengeance', 'SR-02', 'Dutybound: 50

Duty: Personell', '', 1, 5, 'Medic', 12, 12, 195, '', 2, 'DUTY', 'yeah');

INSERT INTO legends.skill (id, career, name, rank) VALUES (1, true, 'Computers (Int)', 2);
INSERT INTO legends.skill (id, career, name, rank) VALUES (2, true, 'Medicine (Int)', 2);
INSERT INTO legends.skill (id, career, name, rank) VALUES (3, true, 'Vigilance (Will)', 1);
INSERT INTO legends.skill (id, career, name, rank) VALUES (4, true, 'Ranged - Light (Ag)', 1);
INSERT INTO legends.skill (id, career, name, rank) VALUES (5, true, 'Ranged - Heavy (Ag)', 1);
INSERT INTO legends.skill (id, career, name, rank) VALUES (6, true, 'Knowledge GCW(Int)', 1);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 1);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 2);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 3);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 4);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 5);
INSERT INTO legends.user_character_skills (player_id, skills_id) VALUES (1, 6);
INSERT INTO legends.talent (id, name, summary) VALUES (1, 'Enduring', '+1 Soak');
INSERT INTO legends.talent (id, name, summary)
VALUES (2, 'Forager', 'Remove 2 black to find food/water/shelter. Survival checks take 1/2 time');
INSERT INTO legends.talent (id, name, summary) VALUES (3, 'Toughened', '+2 Wounds');
INSERT INTO legends.talent (id, name, summary)
VALUES (4, 'Well Rounded', '2 skills become class skills (computers & Mechanic)');
INSERT INTO legends.talent (id, name, summary) VALUES (5, 'Stimpack Specialization', 'Stimpack heals +1');
INSERT INTO legends.talent (id, name, summary) VALUES (6, 'Surgeon', 'Medicine check +1 wound healed');
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 1);
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 2);
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 3);
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 4);
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 5);
INSERT INTO legends.user_character_talents (player_id, talents_id) VALUES (1, 6);