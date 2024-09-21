package com.banmaylanh;

import com.banmaylanh.controller.DangNhapController;
import com.banmaylanh.controller.DangKyController;
import com.banmaylanh.controller.MayLanhController;
import com.banmaylanh.controller.KhachHangController;
import com.banmaylanh.controller.HoaDonController;
import com.banmaylanh.view.LoginView;
import com.banmaylanh.view.RegisterView;
import com.banmaylanh.view.MayLanhView;
import com.banmaylanh.view.KhachHangView;
import com.banmaylanh.view.HoaDonView;

import javax.swing.*;

public class Main { 

    public static void main(String[] args) {
        // Khởi động ứng dụng bằng cách mở giao diện đăng nhập
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            DangNhapController dangNhapController = new DangNhapController(loginView);
            loginView.setVisible(true);
        });
    }

    // Phương thức này có thể được gọi từ controller đăng nhập để chuyển sang các chức năng khác sau khi đăng nhập thành công.
    public static void openMainMenu() {
        // Hiển thị menu chính hoặc điều hướng tới các view khác như quản lý máy lạnh, khách hàng, hóa đơn
        String[] options = {"Quản lý máy lạnh", "Quản lý khách hàng", "Quản lý hóa đơn", "Đăng xuất"};
        int choice = JOptionPane.showOptionDialog(null, "Chọn chức năng", "Menu chính",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0: // Quản lý máy lạnh
                openMayLanhView();
                break;
            case 1: // Quản lý khách hàng
                openKhachHangView();
                break;
            case 2: // Quản lý hóa đơn
                openHoaDonView();
                break;
            case 3: // Đăng xuất
                openLoginView();
                break;
            default:
                break;
        }
    }

    // Hiển thị giao diện quản lý máy lạnh
    public static void openMayLanhView() {
        SwingUtilities.invokeLater(() -> {
            MayLanhView mayLanhView = new MayLanhView();
            MayLanhController mayLanhController = new MayLanhController(mayLanhView);
            mayLanhView.setVisible(true);
        });
    }

    // Hiển thị giao diện quản lý khách hàng
    public static void openKhachHangView() {
        SwingUtilities.invokeLater(() -> {
            KhachHangView khachHangView = new KhachHangView();
            KhachHangController khachHangController = new KhachHangController(khachHangView);
            khachHangView.setVisible(true);
        });
    }

    // Hiển thị giao diện quản lý hóa đơn
    public static void openHoaDonView() {
        SwingUtilities.invokeLater(() -> {
            HoaDonView hoaDonView = new HoaDonView();
            HoaDonController hoaDonController = new HoaDonController(hoaDonView);
            hoaDonView.setVisible(true);
        });
    }

    // Hiển thị lại giao diện đăng nhập khi đăng xuất
    public static void openLoginView() {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            DangNhapController dangNhapController = new DangNhapController(loginView);
            loginView.setVisible(true);
        });
    }

    // Hiển thị giao diện đăng ký khi người dùng muốn tạo tài khoản mới
    public static void openRegisterView() {
        SwingUtilities.invokeLater(() -> {
            RegisterView registerView = new RegisterView();
            DangKyController dangKyController = new DangKyController(registerView);
            registerView.setVisible(true);
        });
    }
}
