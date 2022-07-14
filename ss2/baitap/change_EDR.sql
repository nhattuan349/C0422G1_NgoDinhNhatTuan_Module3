drop database if exists ss2_bai_tap_1;
create database ss2_bai_tap_1;
use ss2_bai_tap_1;

create table vat_tu(
Ma_vtu int auto_increment primary key,
Ten_vtu varchar(45)
);

create table don_dh(
so_dh int auto_increment primary key,
ngay_dh date
);

create table nhac_cc(
ma_ncc int auto_increment primary key,
ten_ncc varchar(45),
dia_chi varchar(45),
sdt int
);

create table phieu_nhap(
so_pn int auto_increment primary key,
ngay_nhap_pn date
);

create table cung_cap(
don_dh int,
nhac_cc int,
foreign key(don_dh) references don_dh(so_dh),
foreign key(nhac_cc) references nhac_cc(ma_ncc)
);

create table chi_tiet_phieu_nhap(
vat_tu int ,
phieu_nhap int ,
dg_nhap int,
sl_nhap int,
foreign key(vat_tu) references  vat_tu(ma_vtu),
foreign key(phieu_nhap) references  phieu_nhap(so_pn)
);

create table chi_tiet_don_dat_hang(
vat_tu int ,
don_dh int ,
foreign key(vat_tu) references vat_tu(ma_vtu),
foreign key(don_dh) references don_dh(so_dh)
);

create table phieu_xuat(
so_px int auto_increment primary key,
ngay_xuat date
);

create table chi_tiet_phieu_xuat(
phieu_xuat int ,
vat_tu int ,
dg_xuat int,
sl_xuat int,
foreign key(phieu_xuat) references phieu_xuat(so_px),
foreign key(vat_tu) references vat_tu(ma_vtu)
);
