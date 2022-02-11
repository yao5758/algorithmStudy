package demo;

import com.umpay.masmgc.sdk.mms.compat.core.message.ap.ApMmsSubmitReq;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bsi.api.client.Client;
import com.bsi.api.client.MmsClient;
import com.bsi.api.pojo.MM7;
import com.bsi.api.pojo.MM7Frame;
import com.cmcc.mm7.vasp.message.MM7DeliveryReportReq;

public class MmsSend {

	// 1 组装无模板彩信
	private MM7 createMM7_1( ) throws Exception {
		String subject = "";// 主题
		String signa = "sss"; // 签名
		String[] mobiles = new String[]{ "***" };
		MM7 mm7 = Client.getInstance( ).createMM7( subject, mobiles, signa );
		List<MM7Frame> frames = new ArrayList<MM7Frame>( );
		MM7Frame frame1 = mm7.addFrame( 15 );// 添加一帧
		frame1.addImage( createByteByFileName( "./data/zq/1.jpg" ) );// byte[]类型参数
		frame1.addText( createByteByFileName( "./data/zq/a.txt" ) );
		frames.add( frame1 );// 添加到List<MM7Frame>

		MM7Frame frame2 = mm7.addFrame( 15 );
		frame2.addImage( createByteByFileName( "./data/zq/2.jpg" ) );
		frame2.addText( createByteByFileName( "./data/zq/b.txt" ) );
		frames.add( frame2 );

		MM7Frame frame3 = mm7.addFrame( 15 );
		frame3.addImage( createByteByFileName( "./data/zq/3.jpg" ) );
		frame3.addText( createByteByFileName( "./data/zq/c.txt" ) );
		frames.add( frame3 );
//
//		MM7Frame frame4 = mm7.addFrame( 15 );
//		frame4.addText( createByteByFileName( "./data/temp/4.txt" ) );
//		frames.add( frame4 );
//
//		MM7Frame frame5 = mm7.addFrame( 15 );
//		frame5.addText( createByteByFileName( "./data/temp/5.txt" ) );
//		frames.add( frame5 );
//
//		MM7Frame frame6 = mm7.addFrame( 15 );
//		frame6.addImage( createByteByFileName( "./data/temp/1490952420.jpg" ) );
//		frames.add( frame6 );
//
//		MM7Frame frame7 = mm7.addFrame( 15 );
//		frame7.addAudio( createByteByFileName( "./data/temp/FFX61N8X.mid" ) );
//		frames.add( frame7 );
//
//		MM7Frame frame8 = mm7.addFrame( 15 );
//		frame8.addImage( createByteByFileName( "./data/temp/riben_175.jpg" ) );
//		frame8.addText( createByteByFileName( "./data/temp/riben_175.txt" ) );
//		frames.add( frame8 );
		return mm7;
	}

	// 2组装无模板定时彩信
	private MM7 createMM7_2( ) throws Exception {
		String subject = "test_subject";// 主题
		String signa = "Vj7nlgsne"; // 签名
		String[] mobiles = new String[]{ "15718861521","15718861521" };
		SimpleDateFormat timer1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Date timer = timer1.parse( "2016-10-26 18:40:00" );
		MM7 mm7 = Client.getInstance( ).createMM7( subject, mobiles, signa, timer );
		List<MM7Frame> frames = new ArrayList<MM7Frame>( );
		MM7Frame frame1 = mm7.addFrame( 15 );// 添加一帧
		frame1.addText( createByteByFileName( "./data/temp/1.txt" ) );// byte[]类型参数
		frames.add( frame1 );// 添加到List<MM7Frame>

		MM7Frame frame2 = mm7.addFrame( 15 );
		frame2.addText( createByteByFileName( "./data/temp/2.txt" ) );
		frames.add( frame2 );

		MM7Frame frame3 = mm7.addFrame( 15 );
		frame3.addText( createByteByFileName( "./data/temp/3.txt" ) );
		frames.add( frame3 );

		MM7Frame frame4 = mm7.addFrame( 15 );
		frame4.addText( createByteByFileName( "./data/temp/4.txt" ) );
		frames.add( frame4 );

		MM7Frame frame5 = mm7.addFrame( 15 );
		frame5.addText( createByteByFileName( "./data/temp/5.txt" ) );
		frames.add( frame5 );

		MM7Frame frame6 = mm7.addFrame( 15 );
		frame6.addText( createByteByFileName( "./data/temp/6.txt" ) );
		frames.add( frame6 );

		MM7Frame frame7 = mm7.addFrame( 15 );
		frame7.addAudio( createByteByFileName( "./data/temp/FFX61N8X.mid" ) );
		frames.add( frame7 );

		MM7Frame frame8 = mm7.addFrame( 15 );
		frame8.addImage( createByteByFileName( "./data/temp/riben_175.jpg" ) );
		frame8.addText( createByteByFileName( "./data/temp/riben_175.txt" ) );
		frames.add( frame8 );
		return mm7;
	}

	private MM7 createMM7_3( ) throws Exception {
		String subject = "test_subject";
		String signa = "Vj7nlgsne";
		String[] mobiles = new String[]{ "15718861521" };
		String tempId = "bac6c06e42f34b70a8483b04591cfcc6";
		MM7 mm7 = Client.getInstance( ).createMM7( subject, mobiles, signa, tempId );
		return mm7;
	}

	private MM7 createMM7_4( ) throws Exception {
		String subject = "test_subject";
		String signa = "Vj7nlgsne";
		String[] mobiles = new String[]{ "15718861521" };
		String tempId = "bac6c06e42f34b70a8483b04591cfcc6";
		SimpleDateFormat timer1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Date timer = timer1.parse( "2016-10-26 18:40:00" );
		MM7 mm7 = Client.getInstance( ).createMM7( subject, mobiles, signa, timer, tempId );
		return mm7;
	}

	public static void main( String[] args ) {
		MmsSend mmsSend = new MmsSend( );
		Client client = Client.getInstance( );
		boolean success = client.login("http://112.******:***", "sss","sss", "ssss");
		if( !success ) {
			return;
		}
		ApMmsSubmitReq req_1 = null;
		// ApMmsSubmitReq req_2 = null;
		// ApMmsSubmitReq req_3 = null;
		// ApMmsSubmitReq req_4 = null;
		try {
			req_1 = MmsClient.getInstance( ).MM72ApMmsSubmitReq( mmsSend.createMM7_1( ) );
			// req_2 = MmsClient.getInstance( ).MM72ApMmsSubmitReq( mmsSend.createMM7_2( ) );
			// req_3 = MmsClient.getInstance( ).MM72ApMmsSubmitReq( mmsSend.createMM7_3( ) );
			// req_4 = MmsClient.getInstance( ).MM72ApMmsSubmitReq( mmsSend.createMM7_4( ) );
			Map<String, String> result_1 = client.sendMms( req_1 );
			// Map<String, String> result_2 = client.sendMms( req_2 );
			// Map<String, String> result_3 = client.sendMms( req_3 );
			// Map<String, String> result_4 = client.sendMms( req_4 );
			System.out.println( result_1 );
			// System.out.println( result_2 );
			// System.out.println( result_3 );
			// System.out.println( result_4 );
			
			while( true ) {
//				List< SubmitReportModel > StatusReportlist = client.getSubmitReport();
				List<MM7DeliveryReportReq> StatusReportlist = client.getReport( );
				if( StatusReportlist.size( ) > 0 ) {

					for( int i = 0; i < StatusReportlist.size( ); i++ ) {
						System.out.println( "-----------------------------------------"+StatusReportlist.get( i ).getMMStatus( ) );
					}
				}
				try {
					Thread.sleep( 1000 );
				} catch( InterruptedException e ) {
				}
			}
			
		} catch( Exception e ) {
			System.out.println( e );
		}
	}

	private byte[] createByteByFileName( String path ) {
		byte[] b = null;
		try {
			b = Files.readAllBytes( Paths.get( path ) );
		} catch( IOException e ) {
			System.out.println( "文件路劲错误或者找不到该多媒体内容 {}" + e );
		}
		return b;
	}
}
