package com.banmaylanh.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonModel {
    private int maHoaDon;
    private int maKhachHang;
    private Date ngayLapHoaDon;
    private double tongTien;

    public HoaDonModel(int maHoaDon, int maKhachHang, Date ngayLapHoaDon, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
    }

    // Getter methods
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    // Thêm hóa đơn
    public static boolean themHoaDon(int maKhachHang, Date ngayLapHoaDon, double tongTien) {
        String sql = "INSERT INTO HoaDon (MaKhachHang, NgayLapHoaDon, TongTien) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maKhachHang);
            ps.setDate(2, ngayLapHoaDon);
            ps.setDouble(3, tongTien);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa hóa đơn
    public static boolean suaHoaDon(int maHoaDon, int maKhachHang, Date ngayLapHoaDon, double tongTien) {
        String sql = "UPDATE HoaDon SET MaKhachHang = ?, NgayLapHoaDon = ?, TongTien = ? WHERE MaHoaDon = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maKhachHang);
            ps.setDate(2, ngayLapHoaDon);
            ps.setDouble(3, tongTien);
            ps.setInt(4, maHoaDon);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa hóa đơn
    public static boolean xoaHoaDon(int maHoaDon) {
        String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maHoaDon);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách hóa đơn
    public static List<HoaDonModel> layDanhSachHoaDon() {
        String sql = "SELECT * FROM HoaDon";
        List<HoaDonModel> danhSachHoaDon = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int maHoaDon = rs.getInt("MaHoaDon");
                int maKhachHang = rs.getInt("MaKhachHang");
                Date ngayLapHoaDon = rs.getDate("NgayLapHoaDon");
                double tongTien = rs.getDouble("TongTien");

                danhSachHoaDon.add(new HoaDonModel(maHoaDon, maKhachHang, ngayLapHoaDon, tongTien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
}
