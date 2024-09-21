-- Tạo cơ sở dữ liệu
CREATE DATABASE QuanLyBanMayLanh;
GO
USE QuanLyBanMayLanh;

-- Bảng Tài khoản (cho đăng nhập và đăng ký)
CREATE TABLE TaiKhoan (
    MaTaiKhoan INT PRIMARY KEY IDENTITY(1,1),
    TenDangNhap NVARCHAR(50) NOT NULL,
    MatKhau NVARCHAR(50) NOT NULL
);

-- Bảng Máy lạnh (quản lý sản phẩm máy lạnh)
CREATE TABLE MayLanh (
    MaMayLanh INT PRIMARY KEY IDENTITY(1,1),
    TenMayLanh NVARCHAR(100) NOT NULL,
    HangSanXuat NVARCHAR(100),
    Gia DECIMAL(18, 2),
    SoLuong INT
);

-- Bảng Khách hàng (quản lý khách hàng)
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY IDENTITY(1,1),
    HoTen NVARCHAR(100),
    SoDienThoai NVARCHAR(15),
    DiaChi NVARCHAR(255)
);

-- Bảng Hóa đơn (quản lý hóa đơn)
CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY IDENTITY(1,1),
    MaKhachHang INT FOREIGN KEY REFERENCES KhachHang(MaKhachHang),
    NgayLapHoaDon DATE,
    TongTien DECIMAL(18, 2)
);

-- Bảng Chi tiết hóa đơn (liên kết giữa hóa đơn và sản phẩm)
CREATE TABLE ChiTietHoaDon (
    MaChiTiet INT PRIMARY KEY IDENTITY(1,1),
    MaHoaDon INT FOREIGN KEY REFERENCES HoaDon(MaHoaDon),
    MaMayLanh INT FOREIGN KEY REFERENCES MayLanh(MaMayLanh),
    SoLuong INT,
    DonGia DECIMAL(18, 2)
);
