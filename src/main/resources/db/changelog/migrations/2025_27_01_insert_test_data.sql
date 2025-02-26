insert into flight_city (id, name, country, timezone) values
    (1, 'Tucaní', 'Venezuela', 'America/Caracas'),
    (2, 'Stockton', 'United States', 'America/Los_Angeles'),
    (3, 'Ngoc Hon Doc', 'Vietnam', 'Asia/Ho_Chi_Minh'),
    (4, 'Starokucherganovka', 'Russia', 'Europe/Volgograd'),
    (5, 'Uusikaupunki', 'Finland', 'Europe/Helsinki'),
    (6, 'Xiaochuan', 'China', 'Asia/Chongqing'),
    (7, 'Béziers', 'France', 'Europe/Paris'),
    (8, 'Bontoc', 'Philippines', 'Asia/Manila'),
    (9, 'Voloka', 'Ukraine', 'Europe/Uzhgorod'),
    (10, 'Intibucá', 'Honduras', 'America/Tegucigalpa'),
    (11, 'Iturama', 'Brazil', 'America/Sao_Paulo'),
    (12, 'Xialiao', 'China', 'Asia/Shanghai'),
    (13, 'Lalagsan', 'Philippines', 'Asia/Manila'),
    (14, 'Mawza‘', 'Yemen', 'Asia/Aden'),
    (15, 'Petropavlovskaya', 'Russia', 'Europe/Moscow'),
    (16, 'Ijuí', 'Brazil', 'America/Sao_Paulo'),
    (17, 'Kardzhin', 'Russia', 'Europe/Moscow'),
    (18, 'Primero de Enero', 'Cuba', 'America/Havana'),
    (19, 'Houston', 'Canada', 'America/Vancouver'),
    (20, 'Bicesse', 'Portugal', 'Europe/Lisbon'),
    (21, 'Le Raincy', 'France', 'Europe/Paris'),
    (22, 'Souillac', 'Mauritius', 'Indian/Mauritius'),
    (23, 'Qianjia', 'China', 'Asia/Chongqing'),
    (24, 'Phibun Mangsahan', 'Thailand', 'Asia/Bangkok'),
    (25, 'Volodars’k-Volyns’kyy', 'Ukraine', 'Europe/Kiev'),
    (26, 'Tianmuhu', 'China', 'Asia/Shanghai'),
    (27, 'Dhahab', 'Egypt', 'Asia/Amman'),
    (28, 'Semënovskoye', 'Russia', 'Europe/Moscow'),
    (29, 'Tužno', 'Croatia', 'Europe/Zagreb'),
    (30, 'San Francisco de Yare', 'Venezuela', 'America/Caracas'),
    (31, 'Kalimati', 'Indonesia', 'Asia/Jakarta'),
    (32, 'Esquel', 'Argentina', 'America/Argentina/Catamarca'),
    (33, 'Jiangchuan', 'China', 'Asia/Chongqing'),
    (34, 'Nyachera', 'Uganda', 'Africa/Kampala'),
    (35, 'Yong’an', 'China', 'Asia/Chongqing'),
    (36, 'Palu', 'Indonesia', 'Asia/Makassar'),
    (37, 'Ballitoville', 'South Africa', 'Africa/Johannesburg'),
    (38, 'Zhendong', 'China', 'Asia/Shanghai'),
    (39, 'Kihangara', 'Tanzania', 'Africa/Dar_es_Salaam'),
    (40, 'Kabakovo', 'Russia', 'Asia/Yekaterinburg'),
    (41, 'Corga', 'Portugal', 'Europe/Lisbon'),
    (42, 'Campo Grande', 'Brazil', 'America/Campo_Grande'),
    (43, 'Garça', 'Brazil', 'America/Sao_Paulo'),
    (44, 'Jiekeng', 'China', 'Asia/Shanghai'),
    (45, 'Taphan Hin', 'Thailand', 'Asia/Bangkok'),
    (46, 'Bizhou', 'China', 'Asia/Harbin'),
    (47, 'Zhukovskiy', 'Russia', 'Europe/Moscow'),
    (48, 'Dayang', 'China', 'Asia/Shanghai'),
    (49, 'Porangaba', 'Brazil', 'America/Sao_Paulo'),
    (50, 'Eiriz', 'Portugal', 'Europe/Lisbon');

insert into flight_airport (id, city, iata_code, icao_code, description, site) values
    (1, 'Margen', 'LHU', 'FYLS', 'Fibrous dysplasia (monostotic), upper arm', 'Drug-induced chronic gout, left hand'),
    (2, 'Tân Hiệp', 'LDZ', 'FALD', 'Disp fx of fourth metatarsal bone, r foot, init for opn fx', 'Incomplete lesion of sacral spinal cord, sequela'),
    (3, 'Socorro', 'OAN', 'MHOA', 'Unsp fx head of unsp femr, 7thF', 'Military operations involving destruction of aircraft'),
    (4, 'Mets Parni', 'BWJ', 'XBWJ', 'War op w acc deton onboard marine weapons, milt, init', 'Stable burst fx fifth lum vertebra, subs for fx w nonunion'),
    (5, 'Velké Meziříčí', 'YMT', 'CYMT', 'Abrasion of penis, subsequent encounter', 'Age-related cognitive decline'),
    (6, 'Oenopu', 'KTX', 'GAKO', 'Toxic effect of other insecticides, assault, sequela', 'Burn of third degree of left ear, initial encounter'),
    (7, 'Turmus‘ayyā', 'FEA', 'XFEA', 'Oth intartic fx low end l rad, subs for clos fx w routn heal', 'Filamentary keratitis'),
    (8, 'Huili', 'POE', 'KPOE', 'Complete traumatic amputation of foot, level unspecified', 'Mech compl of bile duct prosthesis, initial encounter'),
    (9, 'Taloqan', 'NZE', 'GUNZ', 'Nondisp fx of epiphysis (separation) (upper) of right femur', 'Insect bite (nonvenomous) of left wrist, sequela'),
    (10, 'Cangkeuteuk Sabrang', 'SLS', 'LBSS', 'Rotator cuff tear or rupture, not specified as traumatic', 'Unsp traum nondisp spondylolysis of 4th cervcal vert, 7thK'),
    (11, 'Bulumulyo', 'HAY', 'HAY', 'Disorders of muscle in diseases classified elsewhere, hand', 'Unsp fx shaft of unsp fibula, subs for clos fx w delay heal'),
    (12, 'Detik Satu', 'INT', 'KINT', 'Accidental discharge of gas, air or sprng-op gun, subs', 'Prsn brd/alit pk-up/van inj in clsn w nonmtr vehicle, subs'),
    (13, 'Torbay', 'MDH', 'KMDH', 'Unspecified superficial injury of vagina and vulva, sequela', 'Nondisp fx of lateral condyle of unsp femur, init'),
    (14, 'Marco de Canaveses', 'DIM', 'DIDK', 'Oth osteoporosis w current pathological fracture, l forearm', 'Displaced articular fracture of head of unsp femur, sequela'),
    (15, 'Buenos Aires', 'HYN', 'ZSLQ', 'Crushing injury of left ring finger', 'Surfactant mutations of the lung'),
    (16, 'Jenzan', 'BBE', 'YBBE', 'Monocular esotropia with A pattern, right eye', 'Nondisplaced fracture of fourth metatarsal bone, right foot'),
    (17, 'Yên Lập', 'VIX', 'SBVT', 'Other cervical disc degeneration', 'Carrier of infectious disease'),
    (18, 'Nässjö', '0', 'SSQM', 'Occup of pk-up/van injured in clsn w hv veh nontraf, init', 'Cysticercosis'),
    (19, 'Sukoanyar', 'HGU', 'AYMH', 'Pasngr in hv veh inj pick-up truck, pk-up/van in traf, subs', 'Other reactive arthropathies, unspecified wrist'),
    (20, 'Caçador', 'TLH', 'KTLH', 'Cognitive deficits following unsp cerebrovascular disease', 'Early cutaneous congenital syphilis'),
    (21, 'Portoviejo', 'TLP', 'AYQL', 'Unsp inj extensor musc/fasc/tend r mid finger at wrs/hnd lv', 'Osteochondrosis (juvenile) of metacarpal heads, left hand'),
    (22, 'Daguyun', 'LWN', 'UDSG', 'Nondisplaced fracture of unspecified tibial spine, sequela', 'Fracture of unspecified part of clavicle'),
    (23, 'Montalegre', 'XVS', 'LFAV', 'Driver of bus injured in collision w ped/anml in traf, init', 'Displaced dome fx right talus, subs for fx w routn heal'),
    (24, 'Levuka', 'PTN', 'KPTN', 'Mtrcy passenger injured in collision w 2/3-whl mv in traf', 'Unspecified injury of right carotid artery, sequela'),
    (25, 'Vila Verde', 'SEB', 'HLLS', 'Poisoning by androgens and anabolic congeners, acc, subs', 'Leakage of femoral arterial graft (bypass), subs encntr'),
    (26, 'Cholargós', 'ALR', 'NZLX', 'Nontraumatic ischemic infarction of muscle, left shoulder', 'Contact with other specified agricultural machinery, sequela'),
    (27, 'Lubao', 'MXG', 'MXG', 'Ped on sktbrd injured in collision w rail trn/veh nontraf', 'Other chondrocalcinosis, unspecified shoulder'),
    (28, 'Kesheng', 'PUB', 'KPUB', 'Corrosion of third degree of unspecified thigh, init encntr', 'Unspecified injury of right elbow, subsequent encounter'),
    (29, 'Helsingborg', 'ZIS', 'HLZN', 'Milt op w explosn of improv explosv device, milt, init', 'Athscl bypass of cor art of txplt heart w ang pctrs w spasm'),
    (30, 'Volosovo', 'TLH', 'KTLH', 'Unspecified injury of uterus, sequela', 'Nondisplaced fracture of posterior wall of right acetabulum'),
    (31, 'Singapore', 'ASV', 'HKAM', 'Inj msl/tnd lng extensor muscle of toe at ank/ft level', 'Multiple fractures of ribs, bilateral, init for clos fx'),
    (32, 'Hatogaya-honchō', 'LEA', 'YPLM', 'Laceration of musc/fasc/tend prt biceps, left arm, sequela', 'Corrosion of unspecified degree of unspecified palm'),
    (33, 'Malaga', 'HUJ', 'KHHW', 'Unsp fracture of skull, init encntr for closed fracture', 'Acute myeloid leuk w multilin dysplasia, not achieve remis'),
    (34, 'Jiuxian', 'YVM', 'CYVM', 'Sltr-haris Type IV physl fx low end unsp tibia, 7thD', 'Acute gastric ulcer with perforation'),
    (35, 'Pétange', 'JAB', 'YJAB', 'Displ seg fx shaft of rad, l arm, 7thP', 'Nondisp spiral fx shaft of ulna, unsp arm, 7thQ'),
    (36, 'Sablé-sur-Sarthe', 'CKA', 'KCKA', 'Unsp inj flexor musc/fasc/tend unsp fngr at wrs/hnd lv, sqla', 'Underdosing of methylphenidate'),
    (37, 'San Diego', 'DHI', 'VNDH', 'Laceration of lung, unspecified', 'Unsp injury of vein at forearm level, right arm, init encntr'),
    (38, 'Waterloo', 'TGG', 'WMKN', 'Anterior pituitary hormones', 'Pathological fracture, unspecified finger(s), sequela'),
    (39, 'Hanfeng', 'TUT', 'XTUT', 'Disorders of meninges, not elsewhere classified', 'Nondisplaced Maisonneuve''s fracture of unspecified leg'),
    (40, 'Rawaapu', 'AXS', 'KAXS', 'Vesicoureteral-reflux w reflux nephropathy w/o hydroureter', 'Nondisp transverse fx shaft of l tibia, 7thF'),
    (41, 'Sarrebourg', 'ARD', 'WATM', 'Poisoning by opium, assault', 'Other fracture of ilium'),
    (42, 'Bua Yai', '0', 'SBGP', 'Encounter for administrative examinations, unspecified', 'Disp fx of med condyle of r femr, 7thF'),
    (43, 'Rzeszów', 'MXR', 'MXR', 'Calcium deposit in bursa, right elbow', 'Unsp fracture of unsp ilium, subs for fx w delay heal'),
    (44, 'Bidbid', 'MRQ', 'RPUW', 'Syphilitic aortitis', 'Malignant neoplasm of cerebellum'),
    (45, 'Conde', 'BSI', 'RPBL', 'Underdosing of unspecified systemic antibiotic, init encntr', 'Torus fracture of upper end of left humerus, sequela'),
    (46, 'Puerto Madryn', 'RJH', 'VGRJ', 'Calcific tendinitis of right shoulder', 'Renal and perinephric abscess'),
    (47, 'Polešovice', 'KIS', 'HKKI', 'Strain of musc/fasc/tend at shldr/up arm, unsp arm, sequela', 'Sprain of joints and ligaments of unsp parts of neck, subs'),
    (48, 'Cabean', 'KIA', 'KIA', 'Unsp car occ injured in clsn w nonmtr vehicle nontraf, init', 'Traum rupture of ligament of l rng fngr at MCP/IP jt, init'),
    (49, 'Thap Khlo', 'AWN', 'YADS', 'Febrile convulsions', 'Nondisplaced fracture of head of unspecified radius, sequela'),
    (50, 'Nuoxizhi', 'GGT', 'MYEF', 'Breakdown (mechanical) of cardiac electrode, subs encntr', 'Contusion of toe without damage to nail');