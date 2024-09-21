package com.banmaylanh.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangModel {
    private int maKhachHang;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;

    public KhachHangModel(int maKhachHang, String hoTen, String soDienThoai, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Getter methods
    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Thêm khách hàng
    public static boolean themKhachHang(String hoTen, String soDienThoai, String diaChi) {
        String sql = "INSERT INTO KhachHang (HoTen, SoDienThoai, DiaChi) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, hoTen);
            ps.setString(2, soDienThoai);
            ps.setString(3, diaChi);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa khách hàng
    public static boolean suaKhachHang(int maKhachHang, String hoTen, String soDienThoai, String diaChi) {
        String sql = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, DiaChi = ? WHERE MaKhachHang = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, hoTen);
            ps.setString(2, soDienThoai);
            ps.setString(3, diaChi);
            ps.setInt(4, maKhachHang);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa khách hàng
    public static boolean xoaKhachHang(int maKhachHang) {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maKhachHang);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách khách hàng
    public static List<KhachHangModel> layDanhSachKhachHang() {
        String sql = "SELECT * FROM KhachHang";
        List<KhachHangModel> danhSachKhachHang = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int maKhachHang = rs.getInt("MaKhachHang");
                String hoTen = rs.getString("HoTen");
                String soDienThoai = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");

                danhSachKhachHang.add(new KhachHangModel(maKhachHang, hoTen, soDienThoai, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }
}
