package controller;


import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service","/facility"})
public class FacilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IFacilityService facilityService = new FacilityService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertFacility(request, response);
                    break;
                case "edit":
                    updateFacility(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewFormFacility(request, response);
                    break;
                case "edit":
                    showEditFormFacility(request, response);
                    break;
                case "delete":
                    deleteFacility(request, response);
                    break;
                default:
                    listFacility(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Facility> listFacility = facilityService.selectAllFacility();
        request.setAttribute("listFacility", listFacility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maDichVu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        facilityService.deleteFacility(maDichVu);

        List<Facility> listFacility = facilityService.selectAllFacility();
        request.setAttribute("listFacility", listFacility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maDichVu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        Facility existicungFacility = facilityService.selectFacility(maDichVu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/edit.jsp");
        request.setAttribute("facility", existicungFacility);
        dispatcher.forward(request, response);
    }

    private void showNewFormFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        dispatcher.forward(request, response);
    }



    private void insertFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String tenDichVu = request.getParameter("ten_dich_vu");
        int dienTich = Integer.parseInt(request.getParameter("dien_tich"));
        double chiPhiThue =Double.parseDouble(request.getParameter("chi_phi_thue"));
        int soNguoiToiDa = Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int maKieu_Thue = Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int maLoaiDichVu = Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String tieuChuanPhong = request.getParameter("tieu_chuan_phong");
        String moTaTienNghiKhac = request.getParameter("mo_ta_tien_nghi_khac");
        double dienTichHoBoi =Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int soTang = Integer.parseInt(request.getParameter("so_tang"));
        String dichVuMienPhiDiKem = request.getParameter("dich_vu_mien_phi_di_kem");

        Facility newFacility = new Facility(tenDichVu,dienTich, chiPhiThue,soNguoiToiDa,maKieu_Thue,maLoaiDichVu,
                tieuChuanPhong,moTaTienNghiKhac,dienTichHoBoi,soTang,dichVuMienPhiDiKem);
        facilityService.insertFacility(newFacility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maDichVu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        String tenDichVu = request.getParameter("ten_dich_vu");
        int dienTich = Integer.parseInt(request.getParameter("dien_tich"));
        double chiPhiThue =Double.parseDouble(request.getParameter("chi_phi_thue"));
        int soNguoiToiDa = Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int maKieu_Thue = Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int maLoaiDichVu = Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String tieuChuanPhong = request.getParameter("tieu_chuan_phong");
        String moTaTienNghiKhac = request.getParameter("mo_ta_tien_nghi_khac");
        double dienTichHoBoi =Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int soTang = Integer.parseInt(request.getParameter("so_tang"));
        String dichVuMienPhiDiKem = request.getParameter("dich_vu_mien_phi_di_kem");
        Facility book = new Facility(maDichVu,tenDichVu,dienTich, chiPhiThue,soNguoiToiDa,maKieu_Thue,maLoaiDichVu,
                tieuChuanPhong,moTaTienNghiKhac,dienTichHoBoi,soTang,dichVuMienPhiDiKem);

        facilityService.updateFacility(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/edit.jsp");
        dispatcher.forward(request, response);
    }
}







