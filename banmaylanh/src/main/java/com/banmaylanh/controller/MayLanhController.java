package com.banmaylanh.controller;

import com.banmaylanh.model.MayLanhModel;
import com.banmaylanh.view.MayLanhView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MayLanhController {

    private MayLanhView view;

    public MayLanhController(MayLanhView view) {
        this.view = view;

        view.getBtnThem().addActionListener(e -> themMayLanh());
        view.getBtnSua().addActionListener(e -> suaMayLanh());
        view.getBtnXoa().addActionListener(e -> xoaMayLanh());
        view.getBtnCapNhat().addActionListener(e -> capNhatDanhSachMayLanh());

        capNhatDanhSachMayLanh();
    }

    private void themMayLanh() {
        String tenMayLanh = view.getTxtTenMayLanh().getText();
        String hangSanXuat = view.getTxtHangSanXuat().getText();
        double gia = Double.parseDouble(view.getTxtGia().getText());
        int soLuong = Integer.parseInt(view.getTxtSoLuong().getText());

        try {
            if (MayLanhModel.themMayLanh(tenMayLanh, hangSanXuat, gia, soLuong)) {
                JOptionPane.showMessageDialog(view, "Thêm máy lạnh thành công!");
                capNhatDanhSachMayLanh();
            } else {
                JOptionPane.showMessageDialog(view, "Thêm máy lạnh thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void suaMayLanh() {
        int selectedRow = view.getTblMayLanh().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một máy lạnh để sửa!");
            return;
        }

        int maMayLanh = (int) view.getTblMayLanh().getValueAt(selectedRow, 0);
        String tenMayLanh = view.getTxtTenMayLanh().getText();
        String hangSanXuat = view.getTxtHangSanXuat().getText();
        double gia = Double.parseDouble(view.getTxtGia().getText());
        int soLuong = Integer.parseInt(view.getTxtSoLuong().getText());

        try {
            if (MayLanhModel.suaMayLanh(maMayLanh, tenMayLanh, hangSanXuat, gia, soLuong)) {
                JOptionPane.showMessageDialog(view, "Sửa máy lạnh thành công!");
                capNhatDanhSachMayLanh();
            } else {
                JOptionPane.showMessageDialog(view, "Sửa máy lạnh thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void xoaMayLanh() {
        int selectedRow = view.getTblMayLanh().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một máy lạnh để xoá!");
            return;
        }

        int maMayLanh = (int) view.getTblMayLanh().getValueAt(selectedRow, 0);

        try {
            if (MayLanhModel.xoaMayLanh(maMayLanh)) {
                JOptionPane.showMessageDialog(view, "Xoá máy lạnh thành công!");
                capNhatDanhSachMayLanh();
            } else {
                JOptionPane.showMessageDialog(view, "Xoá máy lạnh thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void capNhatDanhSachMayLanh() {
        try {
            List<MayLanhModel> danhSachMayLanh = MayLanhModel.layDanhSachMayLanh();
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblMayLanh().getModel();
            tableModel.setRowCount(0);

            for (MayLanhModel mayLanh : danhSachMayLanh) {
                Object[] rowData = {
                    mayLanh.getMaMayLanh(),
                    mayLanh.getTenMayLanh(),
                    mayLanh.getHangSanXuat(),
                    mayLanh.getGia(),
                    mayLanh.getSoLuong()
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }
}
