package com.banmaylanh.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanModel {
    private int maTaiKhoan;
    private String tenDangNhap;
    private String matKhau;

    public TaiKhoanModel(int maTaiKhoan, String tenDangNhap, String matKhau) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public static boolean themTaiKhoan(String tenDangNhap, String matKhau) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO TaiKhoan (TenDangNhap, MatKhau) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tenDangNhap);
        ps.setString(2, matKhau);
        int rows = ps.executeUpdate();
        conn.close();
        return rows > 0;
    }

    public static boolean kiemTraDangNhap(String tenDangNhap, String matKhau) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tenDangNhap);
        ps.setString(2, matKhau);
        ResultSet rs = ps.executeQuery();
        boolean result = rs.next();
        conn.close();
        return result;
    }
}
