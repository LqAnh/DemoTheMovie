# DemoTheMovie

TÀI KHOẢN LOGIN 
USERNAME: lqanh
PASSWORD: Lqa1234

CAUTION:
1), THIẾT BỊ CẦN PHẢI KẾT NỐI INTERNET
 	
2), CHỨC NĂNG BOOK VÉ VẪN ĐANG HOÀN THIỆN

KIẾN TRÚC CHƯƠNG TRÌNH SỬ DỤNG MÔ HÌNH MVVM CỤ THỂ NHƯ SAU:

Package adapter: 
		FilmAdapter: đổ dữ liệu cho recycleview ở Fragment 002
		
		ReviewFilmAdapter: đổ dữ liệu cho recycleview ở Fragment 005

Package api: 
	package model: các class chuyển dữ liệu từ file json thành đối tượng

		AccReqModel: tài khoản, mật khẩu
		
		TokenResModel: lấy token 

		MovieModel: lấy danh sách phim

		DetailMovieModel: lấy chi tiết phim dựa vào movieId được click ở recycleview

		TrailerFilmModel: lấy trailer phim dựa vào movieId	
		
		ReviewFilmModel: lấy review phim dựa vào movieId

  	interface api: khai báo các phương thức để call api

Package view:
	
	package act: 
		baseact: các phương thức dùng chung
		MainAct: quản lý callback chuyển màn cho các fragment
		CinemaAct: quản lý việc mở các app để book vé 
	
	package fragment:
		baseFragment: các phương thức dùng chung
		m000: giao diện splash chào mừng
		m001: quản lý giao diện màn hình login          
		m002: recycle view đổ dữ liệu thành list từ server trả về
		m003: detail movie gồm: ngày chiếu, độ dài phim, poster, overview từ server trả về 
		m004: mở ra youtube xem trailer
		m005: review của người xem		
	
	package viewmodel: xử lý dữ liệu 
		baseViewModel: phương thức dùng chung
		m000: kiểm tra có token chưa để không cần đăng nhập lại
		m001:  kiểm tra tài khoản mật khẩu, thực hiện login, lưu token vào sharePreference để lần sau không cần nhập lại
		m002: call api để lấy đanh sách movie
		m003: call api đề lấy detail movie
		m004: call api để lấy key video trên youtube
		m005: call api lấy review của người dùng

App: application context  

CommonUtils: singleton chứa các phương thức cho sharePreference để ghi nhớ đăng nhập

OnActionCallBack: callBack sử dụng cơ chế(key value)