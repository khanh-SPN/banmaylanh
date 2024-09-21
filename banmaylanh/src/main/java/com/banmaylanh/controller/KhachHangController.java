package com.banmaylanh.controller;

import com.banmaylanh.model.KhachHangModel;
import com.banmaylanh.view.KhachHangView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class KhachHangController {

    private KhachHangView view;

    public KhachHangController(KhachHangView view) {
        this.view = view;

        view.getBtnThem().addActionListener(e -> themKhachHang());
        view.getBtnSua().addActionListener(e -> suaKhachHang());
        view.getBtnXoa().addActionListener(e -> xoaKhachHang());
        view.getBtnCapNhat().addActionListener(e -> capNhatDanhSachKhachHang());

        capNhatDanhSachKhachHang();
    }

    private void themKhachHang() {
        String hoTen = view.getTxtHoTen().getText();
        String soDienThoai = view.getTxtSoDienThoai().getText();
        String diaChi = view.getTxtDiaChi().getText();

        try {
            if (KhachHangModel.themKhachHang(hoTen, soDienThoai, diaChi)) {
                JOptionPane.showMessageDialog(view, "Thêm khách hàng thành công!");
                capNhatDanhSachKhachHang();
            } else {
                JOptionPane.showMessageDialog(view, "Thêm khách hàng thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void suaKhachHang() {
        int selectedRow = view.getTblKhachHang().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một khách hàng để sửa!");
            return;
        }

        int maKhachHang = (int) view.getTblKhachHang().getValueAt(selectedRow, 0);
        String hoTen = view.getTxtHoTen().getText();
        String soDienThoai = view.getTxtSoDienThoai().getText();
        String diaChi = view.getTxtDiaChi().getText();

        try {
            if (KhachHangModel.suaKhachHang(maKhachHang, hoTen, soDienThoai, diaChi)) {
                JOptionPane.showMessageDialog(view, "Sửa khách hàng thành công!");
                capNhatDanhSachKhachHang();
            } else {
                JOptionPane.showMessageDialog(view, "Sửa khách hàng thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void xoaKhachHang() {
        int selectedRow = view.getTblKhachHang().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một khách hàng để xoá!");
            return;
        }

        int maKhachHang = (int) view.getTblKhachHang().getValueAt(selectedRow, 0);

        try {
            if (KhachHangModel.xoaKhachHang(maKhachHang)) {
                JOptionPane.showMessageDialog(view, "Xoá khách hàng thành công!");
                capNhatDanhSachKhachHang();
            } else {
                JOptionPane.showMessageDialog(view, "Xoá khách hàng thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void capNhatDanhSachKhachHang() {
        try {
            List<KhachHangModel> danhSachKhachHang = KhachHangModel.layDanhSachKhachHang();
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblKhachHang().getModel();
            tableModel.setRowCount(0);

            for (KhachHangModel khachHang : danhSachKhachHang) {
                Object[] rowData = {
                    khachHang.getMaKhachHang(),
                    khachHang.getHoTen(),
                    khachHang.getSoDienThoai(),
                    khachHang.getDiaChi()
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }
}
