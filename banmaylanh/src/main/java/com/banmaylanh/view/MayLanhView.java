package com.banmaylanh.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MayLanhView extends javax.swing.JFrame {

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapNhat;
    private JLabel lblTitle;
    private JLabel lblTenMayLanh;
    private JLabel lblHangSanXuat;
    private JLabel lblGia;
    private JLabel lblSoLuong;
    private JTextField txtTenMayLanh;
    private JTextField txtHangSanXuat;
    private JTextField txtGia;
    private JTextField txtSoLuong;
    private JTable tblMayLanh;
    private JScrollPane jScrollPane1;

    public MayLanhView() {
        initComponents();
    }

    private void initComponents() {

        lblTitle = new JLabel();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnCapNhat = new JButton();
        lblTenMayLanh = new JLabel();
        lblHangSanXuat = new JLabel();
        lblGia = new JLabel();
        lblSoLuong = new JLabel();
        txtTenMayLanh = new JTextField();
        txtHangSanXuat = new JTextField();
        txtGia = new JTextField();
        txtSoLuong = new JTextField();
        jScrollPane1 = new JScrollPane();
        tblMayLanh = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMayLanh.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[] {
                "Tên Máy Lạnh", "Hãng Sản Xuất", "Giá", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(tblMayLanh);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Quản lý máy lạnh");

        lblTenMayLanh.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblTenMayLanh.setText("Tên máy lạnh");

        lblHangSanXuat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblHangSanXuat.setText("Hãng sản xuất");

        lblGia.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblGia.setText("Giá");

        lblSoLuong.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblSoLuong.setText("Số lượng");

        btnThem.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnThem.setText("Thêm");

        btnSua.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnSua.setText("Sửa");

        btnXoa.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnXoa.setText("Xoá");

        btnCapNhat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnCapNhat.setText("Cập nhật");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenMayLanh)
                            .addComponent(lblHangSanXuat)
                            .addComponent(lblGia)
                            .addComponent(lblSoLuong))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGia)
                            .addComponent(txtSoLuong)
                            .addComponent(txtHangSanXuat)
                            .addComponent(txtTenMayLanh, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(lblTitle)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenMayLanh)
                    .addComponent(txtTenMayLanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHangSanXuat)
                    .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGia)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

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

    public JTable getTblMayLanh() {
        return tblMayLanh;
    }

    public JTextField getTxtTenMayLanh() {
        return txtTenMayLanh;
    }

    public JTextField getTxtHangSanXuat() {
        return txtHangSanXuat;
    }

    public JTextField getTxtGia() {
        return txtGia;
    }

    public JTextField getTxtSoLuong() {
        return txtSoLuong;
    }
}