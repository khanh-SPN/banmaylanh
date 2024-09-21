package com.banmaylanh.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KhachHangView extends javax.swing.JFrame {

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapNhat;
    private JLabel lblTitle;
    private JLabel lblHoTen;
    private JLabel lblSoDienThoai;
    private JLabel lblDiaChi;
    private JTextField txtHoTen;
    private JTextField txtSoDienThoai;
    private JTextField txtDiaChi;
    private JTable tblKhachHang;
    private JScrollPane jScrollPane1;

    public KhachHangView() {
        initComponents();
    }

    private void initComponents() {

        lblTitle = new JLabel();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnCapNhat = new JButton();
        lblHoTen = new JLabel();
        lblSoDienThoai = new JLabel();
        lblDiaChi = new JLabel();
        txtHoTen = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();
        jScrollPane1 = new JScrollPane();
        tblKhachHang = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblKhachHang.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String[] {
                "Họ Tên", "Số Điện Thoại", "Địa Chỉ"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Quản lý khách hàng");

        lblHoTen.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblHoTen.setText("Họ tên");

        lblSoDienThoai.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblSoDienThoai.setText("Số điện thoại");

        lblDiaChi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblDiaChi.setText("Địa chỉ");

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

    public JTextField getTxtHoTen() {
        return txtHoTen;
    }

    public JTextField getTxtSoDienThoai() {
        return txtSoDienThoai;
    }

    public JTextField getTxtDiaChi() {
        return txtDiaChi;
    }

    public JTable getTblKhachHang() {
        return tblKhachHang;
    }
}
