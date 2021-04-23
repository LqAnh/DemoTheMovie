# DemoTheMovie

TÀI KHOẢN LOGIN 
USERNAME: lqanh
PASSWORD: Lqa1234

CAUTION:
1), THIẾT BỊ CẦN PHẢI KẾT NỐI INTERNET
 	
2), CHỨC NĂNG BOOK VÉ VẪN ĐANG HOÀN THIỆN

KIẾN TRÚC CHƯƠNG TRÌNH SỬ DỤNG MÔ HÌNH MVVM CỤ THỂ NHƯ SAU:

Package adapter: 
	class FilmAdapter: đổ dữ liệu cho recycleview

Package api: 
	package model: các class chuyển dữ liệu từ file json thành đối tượng

		AccReqModel: tài khoản, mật khẩu
		
		TokenResModel: lấy token success hay không
		
		MovieModel: lấy danh sách phim

		DetailMovieModel: lấy chi tiết phim dựa vào movieId được click ở recycleview

		TrailerFilmModel: lấy trailer phim dựa vào movieId	

  	interface api: khai báo các phương thức để call api

Package view:
	
	package act: 
		baseact: các phương thức dùng chung
		mainAct: quản lý callback chuyển màn cho các fragment
	
	package fragment:
		baseFragment: các phương thức dùng chung
		m001: quản lý giao diện màn hình login.          
		m002: recycle view đổ dữ liệu thành list từ server trả về
		m003: detail movie gồm: ngày chiếu, độ dài phim, poster, overview từ server trả về 
		m004: mở ra youtube xem trailer		
	
	package viewmodel: xử lý dữ liệu 
		baseViewModel: phương thức dùng chung
		m001:  kiểm tra tài khoản mật khẩu, thực hiện login, lưu vào sharePreference để lần 											sau không cần nhập lại
		m002: call api để lấy đanh sách movie
		m003: call api đề lấy detail movie
		m004: call api để lấy key video trên youtube

App: application context  

CommonUtils: singleton chứ các phương thức cho sharePreference

OnActionCallBack: callBack sử dụng cơ chế(key value)