package entity.shipping;

/**
 * @author
 */
public class ShippingConfigs {
    // Common Coupling: sử dụng biến static và có thể truy cập public
<<<<<<< HEAD
    public static final int PROVINCE_A = 22;
    public static final int PROVINCE_B = 48;

=======
>>>>>>> 9252411cba2ef6e236b0bbaaf4b5fb41b8514b4b
    public static String[] PROVINCES = {
            "Bắc Giang", 	"Bắc Kạn", 			"Cao Bằng", 	"Hà Giang", 	"Lạng Sơn", 	"Phú Thọ",
            "Quảng Ninh", 	"Thái Nguyên", 		"Tuyên Quang", 	"Yên Bái", 		"Điện Biên", 	"Hòa Bình",
            "Lai Châu", 	"Sơn La", 			"Bắc Ninh", 	"Hà Nam", 		"Hải Dương", 	"Hưng Yên",
            "Nam Định", 	"Ninh Bình", 		"Thái Bình", 	"Vĩnh Phúc", 	"Hà Nội", 		"Hải Phòng",
            "Hà Tĩnh", 		"Nghệ An", 			"Quảng Bình", 	"Quảng Trị", 	"Thanh Hóa", 	"Thừa Thiên-Huế",
            "Đắk Lắk", 		"Đắk Nông", 		"Gia Lai", 		"Kon Tum", 		"Lâm Đồng", 	"Bình Định",
            "Bình Thuận", 	"Khánh Hòa", 		"Ninh Thuận", 	"Phú Yên", 		"Quảng Nam", 	"Quảng Ngãi",
            "Đà Nẵng", 		"Bà Rịa-Vũng Tàu", 	"Bình Dương", 	"Bình Phước", 	"Đồng Nai", 	"Tây Ninh",
            "Hồ Chí Minh", 	"An Giang", 		"Bạc Liêu", 	"Bến Tre", 		"Cà Mau", 		"Đồng Tháp",
            "Hậu Giang", 	"Kiên Giang", 		"Long An", 		"Sóc Trăng", 	"Tiền Giang", 	"Trà Vinh",
            "Vĩnh Long", 	"Cần Thơ" };

    public static int[] RUSH_SUPPORT_PROVINCES_INDEX = {PROVINCE_A, PROVINCE_B};//Clean Code: Vi pham cach dat ten bien,
}
