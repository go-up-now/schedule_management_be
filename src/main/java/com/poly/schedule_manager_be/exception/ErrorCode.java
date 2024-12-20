package com.poly.schedule_manager_be.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED(999, "Chưa phân loại", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_EXISTED(400, "Người dùng này không tồn tại", HttpStatus.NOT_FOUND),
    INVALID_KEY(401, "Từ khóa lỗi không hợp lệ", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(402, "Vui lòng nhập email", HttpStatus.NO_CONTENT),
    PASSWORD_INVALID(403, "Mật khẩu phải ít nhất 5 ký tự", HttpStatus.NO_CONTENT),
    USER_EXISTED(404, "Email này đã tồn tại", HttpStatus.FOUND),
    PASSWORD_NOT_BLANK(405, "Vui lòng nhập mật khẩu", HttpStatus.NO_CONTENT),
    STUDENT_NOT_EXISTED(406, "Sinh viên này không tồn tại", HttpStatus.NOT_FOUND),
    CODE_NOT_BLANK(407, "Vui lòng nhập mã code", HttpStatus.NO_CONTENT),
    CLAZZ_EXISTED(408, "Lớp học này đã tồn tại", HttpStatus.FOUND),
    SUBJECT_NOT_EXISTED(409, "Môn học này không tồn tại", HttpStatus.NOT_FOUND),
    INSTRUCTOR_NOT_EXISTED(501, "Giảng viên này không tồn tại", HttpStatus.NOT_FOUND),
    SHIFT_NOT_EXISTED(502, "Ca học này không tồn tại", HttpStatus.NOT_FOUND),
    ROOM_NOT_EXISTED(503, "Phòng học này không tồn tại", HttpStatus.NOT_FOUND),
    CLAZZ_NOT_EXISTED(504, "Lớp học này không tồn tại", HttpStatus.NOT_FOUND),
    FULL_CLAZZ(505, "Lớp học này đã đủ sinh viên, vui lòng chọn lớp khác", HttpStatus.BAD_REQUEST),
    PASSWORD_UNAUTHENTICATED(506, "Tài khoản hoặc mật khẩu không chính xác", HttpStatus.UNAUTHORIZED),
    UNAUTHENTICATED(507, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    STUDENT_EXIST_IN_CLAZZ(508, "Bạn đã đăng ký lớp học này rồi", HttpStatus.BAD_REQUEST),
    NOT_STUDENT(509, "Bạn không phải là sinh viên", HttpStatus.NOT_FOUND),
    CLAZZ_REGISTERED(600, "Bạn đã đăng ký lớp học lớp này, vui lòng chọn lớp khác", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(507, "Bạn không có quyền truy cập", HttpStatus.FORBIDDEN),
    USER_CODE_EXISTED(404, "Mã người dùng này đã tồn tại", HttpStatus.NOT_FOUND),
    AREA_NOT_EXISTS(404, "Khu vực này không tồn tại", HttpStatus.NOT_FOUND),
    EDUCATION_PROGRAM_NOT_EXISTS(404, "Chương trình đào tạo này không tồn tại", HttpStatus.NOT_FOUND),
    STUDENT_CANNOT_DELETE(404, "Sinh viên này đã đăng ký lớp học, không thể xóa", HttpStatus.BAD_REQUEST),
    CLAZZ_CANNOT_DELETE(404, "Lớp học này đã có sinh viên đăng ký, không thể xóa", HttpStatus.BAD_REQUEST),
    SEMESTER_PROGRESS_NOT_OPEN(404, "Tiến trình chưa mở", HttpStatus.NOT_FOUND),
    PRIVATE_MAJOR_NOT_EXISTED(409, "Chuyên ngành hẹp này không tồn tại", HttpStatus.NOT_FOUND),
    STUDYIN_NOT_EXISTED(404, "Lớp học của môn học này không tồn tại", HttpStatus.NOT_FOUND),
    STUDY_HISTORY_NOT_EXISTED(404, "Lịch sử học tập này không tồn tại", HttpStatus.NOT_FOUND),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    int code;
    String message;
    HttpStatusCode statusCode;
}
