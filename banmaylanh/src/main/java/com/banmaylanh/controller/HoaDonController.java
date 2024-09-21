package com.banmaylanh.controller;

import com.banmaylanh.model.HoaDonModel;
import com.banmaylanh.view.HoaDonView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.List;

public class HoaDonController {

    private HoaDonView view;

    public HoaDonController(HoaDonView view) {
        this.view = view;

        view.getBtnThem().addActionListener(e -> themHoaDon());
        view.getBtnSua().addActionListener(e -> suaHoaDon());
        view.getBtnXoa().addActionListener(e -> xoaHoaDon());
        view.getBtnCapNhat().addActionListener(e -> capNhatDanhSachHoaDon());

        capNhatDanhSachHoaDon();
    }

    private void themHoaDon() {
        int maKhachHang = Integer.parseInt(view.getTxtMaKhachHang().getText());
        Date ngayLapHoaDon = Date.valueOf(view.getTxtNgayLapHoaDon().getText());
        double tongTien = Double.parseDouble(view.getTxtTongTien().getText());

        try {
            if (HoaDonModel.themHoaDon(maKhachHang, ngayLapHoaDon, tongTien)) {
                JOptionPane.showMessageDialog(view, "Thêm hoá đơn thành công!");
                capNhatDanhSachHoaDon();
            } else {
                JOptionPane.showMessageDialog(view, "Thêm hoá đơn thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void suaHoaDon() {
        int selectedRow = view.getTblHoaDon().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một hoá đơn để sửa!");
            return;
        }

        int maHoaDon = (int) view.getTblHoaDon().getValueAt(selectedRow, 0);
        int maKhachHang = Integer.parseInt(view.getTxtMaKhachHang().getText());
        Date ngayLapHoaDon = Date.valueOf(view.getTxtNgayLapHoaDon().getText());
        double tongTien = Double.parseDouble(view.getTxtTongTien().getText());

        try {
            if (HoaDonModel.suaHoaDon(maHoaDon, maKhachHang, ngayLapHoaDon, tongTien)) {
                JOptionPane.showMessageDialog(view, "Sửa hoá đơn thành công!");
                capNhatDanhSachHoaDon();
            } else {
                JOptionPane.showMessageDialog(view, "Sửa hoá đơn thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void xoaHoaDon() {
        int selectedRow = view.getTblHoaDon().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn một hoá đơn để xoá!");
            return;
        }

        int maHoaDon = (int) view.getTblHoaDon().getValueAt(selectedRow, 0);

        try {
            if (HoaDonModel.xoaHoaDon(maHoaDon)) {
                JOptionPane.showMessageDialog(view, "Xoá hoá đơn thành công!");
                capNhatDanhSachHoaDon();
            } else {
                JOptionPane.showMessageDialog(view, "Xoá hoá đơn thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }

    private void capNhatDanhSachHoaDon() {
        try {
            List<HoaDonModel> danhSachHoaDon = HoaDonModel.layDanhSachHoaDon();
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblHoaDon().getModel();
            tableModel.setRowCount(0);

            for (HoaDonModel hoaDon : danhSachHoaDon) {
                Object[] rowData = {
                    hoaDon.getMaHoaDon(),
                    hoaDon.getMaKhachHang(),
                    hoaDon.getNgayLapHoaDon(),
                    hoaDon.getTongTien()
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu!");
        }
    }
}
