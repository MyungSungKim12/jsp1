package model;

import java.util.ArrayList;

import java.sql.*;

public class PostDAO {
	
	//게시글등록
		public void update(PostVo vo) {
			try {
				String sql = "update posts set title=?, body=?, date=now() where id=?";
				PreparedStatement ps = DB.CON.prepareStatement(sql);
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getBody());
				ps.setInt(3, vo.getId());
				ps.execute();
			}catch(Exception e) {
				System.out.println("게시글 수정:" + e.toString());
			}
		}
	
	//게시글 삭제
		public void delete(int id) {
			try {
				String sql = "delete from posts where id=?" + id;
				PreparedStatement ps = DB.CON.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
			}catch(Exception e) {
				System.out.println("게시글삭제:" + e.toString());
			}
		}
	
	//게시글정보 읽기
	public PostVo read(int id) {
		PostVo vo = new PostVo();
		try {
			String sql = "select * from posts where id=?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				System.out.println(vo.toString());
			}
		}catch(Exception e){
			System.out.println("게시글정보....." + e.toString());
		}
		return vo;
	}
	
	
	//게시글등록
	public void insert(PostVo vo) {
		try {
			String sql = "insert into posts(title, body, writer) values(?,?,?)";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setString(3, vo.getWriter());
			ps.execute();
		}catch(Exception e) {
			System.out.println("게시글등록:" + e.toString());
		}
	}
	
	//게시글목록
	public ArrayList<PostVo> list(){
		ArrayList<PostVo> array = new ArrayList<PostVo>();
		try {
			String sql = "select * from posts order by id desc limit 0,5";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PostVo vo = new PostVo();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				array.add(vo);
				System.out.println(vo.toString());
			}
		}catch(Exception e){
			System.out.println("post list....." + e.toString());
		}
		
		return array;
	}

}
