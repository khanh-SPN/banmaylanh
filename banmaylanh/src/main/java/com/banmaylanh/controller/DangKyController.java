package com.banmaylanh.controller;

import com.banmaylanh.model.TaiKhoanModel;
import com.banmaylanh.view.RegisterView;
import javax.swing.JOptionPane;

public class DangKyController {

    private RegisterView view;

    public DangKyController(RegisterView view) {
        this.view = view;

        view.getBtnDangKy().addActionListener(e -> dangKy());
    }

    private void dangKy() {
        String tenDangNhap = view.getTenDangNhap();
        String matKhau = view.getMatKhau();
        try {
            if (TaiKhoanModel.themTaiKhoan(tenDangNhap, matKhau)) {
                JOptionPane.showMessageDialog(view, "Đăng ký thành công!");
                // Đóng form đăng ký hoặc chuyển về trang đăng nhập
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Đăng ký thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }
}
