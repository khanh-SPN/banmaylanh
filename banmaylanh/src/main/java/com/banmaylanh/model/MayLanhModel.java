package com.banmaylanh.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MayLanhModel {
    private int maMayLanh;
    private String tenMayLanh;
    private String hangSanXuat;
    private double gia;
    private int soLuong;

    public MayLanhModel(int maMayLanh, String tenMayLanh, String hangSanXuat, double gia, int soLuong) {
        this.maMayLanh = maMayLanh;
        this.tenMayLanh = tenMayLanh;
        this.hangSanXuat = hangSanXuat;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    // Getter methods
    public int getMaMayLanh() {
        return maMayLanh;
    }

    public String getTenMayLanh() {
        return tenMayLanh;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Thêm máy lạnh
    public static boolean themMayLanh(String tenMayLanh, String hangSanXuat, double gia, int soLuong) {
        String sql = "INSERT INTO MayLanh (TenMayLanh, HangSanXuat, Gia, SoLuong) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, tenMayLanh);
            ps.setString(2, hangSanXuat);
            ps.setDouble(3, gia);
            ps.setInt(4, soLuong);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa máy lạnh
    public static boolean suaMayLanh(int maMayLanh, String tenMayLanh, String hangSanXuat, double gia, int soLuong) {
        String sql = "UPDATE MayLanh SET TenMayLanh = ?, HangSanXuat = ?, Gia = ?, SoLuong = ? WHERE MaMayLanh = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, tenMayLanh);
            ps.setString(2, hangSanXuat);
            ps.setDouble(3, gia);
            ps.setInt(4, soLuong);
            ps.setInt(5, maMayLanh);
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa máy lạnh
    public static boolean xoaMayLanh(int maMayLanh) {
        String sql = "DELETE FROM MayLanh WHERE MaMayLanh = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maMayLanh);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách máy lạnh
    public static List<MayLanhModel> layDanhSachMayLanh() {
        String sql = "SELECT * FROM MayLanh";
        List<MayLanhModel> danhSachMayLanh = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int maMayLanh = rs.getInt("MaMayLanh");
                String tenMayLanh = rs.getString("TenMayLanh");
                String hangSanXuat = rs.getString("HangSanXuat");
                double gia = rs.getDouble("Gia");
                int soLuong = rs.getInt("SoLuong");

                danhSachMayLanh.add(new MayLanhModel(maMayLanh, tenMayLanh, hangSanXuat, gia, soLuong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMayLanh;
    }
}
