package com.banmaylanh.controller;

import com.banmaylanh.model.TaiKhoanModel;
import com.banmaylanh.view.LoginView;
import javax.swing.JOptionPane;

public class DangNhapController {

    private LoginView view;

    public DangNhapController(LoginView view) {
        this.view = view;

        view.getBtnDangNhap().addActionListener(e -> dangNhap());
        view.getBtnDangKy().addActionListener(e -> moDangKy());
    }

    private void dangNhap() {
        String tenDangNhap = view.getTenDangNhap();
        String matKhau = view.getMatKhau();
        try {
            if (TaiKhoanModel.kiemTraDangNhap(tenDangNhap, matKhau)) {
                JOptionPane.showMessageDialog(view, "Đăng nhập thành công!");
                // Chuyển tới giao diện quản lý chính (ví dụ: MayLanhView hoặc KhachHangView)
            } else {
                JOptionPane.showMessageDialog(view, "Tên đăng nhập hoặc mật khẩu không đúng!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void moDangKy() {
        // Mở form đăng ký
        // Ví dụ: new RegisterView().setVisible(true);
    }
}
