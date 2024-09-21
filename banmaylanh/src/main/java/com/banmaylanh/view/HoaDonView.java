package com.banmaylanh.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HoaDonView extends javax.swing.JFrame {

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapNhat;
    private JLabel lblTitle;
    private JLabel lblMaKhachHang;
    private JLabel lblNgayLapHoaDon;
    private JLabel lblTongTien;
    private JTextField txtMaKhachHang;
    private JTextField txtNgayLapHoaDon;
    private JTextField txtTongTien;
    private JTable tblHoaDon;
    private JScrollPane jScrollPane1;

    public HoaDonView() {
        initComponents();
    }

    private void initComponents() {

        lblTitle = new JLabel();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnCapNhat = new JButton();
        lblMaKhachHang = new JLabel();
        lblNgayLapHoaDon = new JLabel();
        lblTongTien = new JLabel();
        txtMaKhachHang = new JTextField();
        txtNgayLapHoaDon = new JTextField();
        txtTongTien = new JTextField();
        jScrollPane1 = new JScrollPane();
        tblHoaDon = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHoaDon.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Ngày Lập", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Quản lý hóa đơn");

        lblMaKhachHang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblMaKhachHang.setText("Mã khách hàng");

        lblNgayLapHoaDon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblNgayLapHoaDon.setText("Ngày lập hóa đơn");

        lblTongTien.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblTongTien.setText("Tổng tiền");

        btnThem.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnThem.setText("Thêm");

        btnSua.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnSua.setText("Sửa");

        btnXoa.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnXoa.setText("Xoá");

        btnCapNhat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnCapNhat.setText("Cập nhật");

        // Layout code...

        pack();
        setLocationRelativeTo(null);
    }

    // Getter methods
    public JButton getBtnThem() {
        return btnThem;
    }

    public JButton getBtnSua() {
        return btnSua;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public JButton getBtnCapNhat() {
        return btnCapNhat;
    }

    public JTextField getTxtMaKhachHang() {
        return txtMaKhachHang;
    }

    public JTextField getTxtNgayLapHoaDon() {
        return txtNgayLapHoaDon;
    }

    public JTextField getTxtTongTien() {
        return txtTongTien;
    }

    public JTable getTblHoaDon() {
        return tblHoaDon;
    }
}
