package net.hk.htmlfetch;

import com.alibaba.fastjson.JSONObject;
import net.hk.util.DateUtil;
import net.hk.util.FileUtil;

import javax.net.ssl.TrustManager;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/9.
 */
public class Fetch51job {

    public static void main(String[] args){

        String cur_time_sign  = DateUtil.format(new Date(), DateUtil.DATE_HMS_FORMAT_SIGN);

        System.out.println("当前执行任务时间：" + cur_time_sign);
//        String url = "http://id.ifeng.com/";
//        String cookieStr = "userid=1474598455785_zafeq1753; vjuids=7687c48f2.1586c139de4.0.5550ecc271b2; __gads=ID=5e98126a7174baf9:T=1484703558:S=ALNI_Ma-oevqt9HNdQMhu3tQOudSdjlEuA; UM_distinctid=15cbf10d9b871-05f574c74e966a-3c365601-13c680-15cbf10d9b9c97; BDTUJIAID=a7d0f918e977275e11b9e8d199349548; selCityName=%E6%9D%AD%E5%B7%9E; _ga=GA1.2.832174270.1500275498; vjlast=1479281975.1500538184.11; autologin=0; Hm_lvt_b64c5492cbc3815e527cf22d1857788e=1500623806; PHPSESSID=qcltasa6d5dmggd6t2eba4lvn2; IF_TIME=1501229423520; IF_REAL=0; sid=BD9795066172D1997C77249D81318642user84495865; IF_USER=hutaisi%40worken.cn; reborn=BXANJQxmVH0BNVBiVmVUbQA5WzgCY1Jn; prov=cn0571; city=0571; weather_city=zj_hz; region_ip=115.238.44.226; region_ver=1.30";
//        String url = "http://ehire.51job.com/Candidate/ResumeView.aspx?hidUserID=455602910&hidEvents=23&pageCode=3&hidKey=d8ff1235fb707f6b6c228f6eff61a678";
//        String cookieStr ="guid=15020009475712930062; EhireGuid=5153d167c30149f2860f69fa195f3c38; 51job=cenglish%3D0; ASP.NET_SessionId=arv2zsybp5t2uuh2mej31nqy; HRUSERINFO=CtmID=3330726&DBID=2&MType=02&HRUID=4174733&UserAUTHORITY=1111111111&IsCtmLevle=1&UserName=hkdw8388&IsStandard=0&LoginTime=08%2f09%2f2017+11%3a13%3a34&ExpireTime=08%2f09%2f2017+11%3a23%3a34&CtmAuthen=0000011000000001000110010000000011100001&BIsAgreed=true&IsResetPwd=0&CtmLiscense=1&AccessKey=a15121d54380ee6d; AccessKey=e7090a77812b44a; KWD=SEARCH=; LangType=Lang=&Flag=1";

//        String cookieStr = "urlfrom=121113803; urlfrom2=121113803; adfcid=pzzhubiaoti1; adfcid2=pzzhubiaoti1; adfbid=0; adfbid2=0; dywez=95841923.1502703389.2.2.dywecsr=zhaopin.com|dyweccn=(referral)|dywecmd=referral|dywectr=undefined|dywecct=/; __xsptplus30=30.2.1502703389.1502703389.1%234%7C%7C%7C%7C%7C%23%23lfRGPMQpDTQFBiTxVY3WPyCtwMg3JiXy%23; pcc=r=961464233&t=0; _jzqa=1.1622623789528813800.1498471850.1498471850.1502703389.2; _jzqc=1; _jzqx=1.1498471850.1502703389.1.jzqsr=zhaopin%2Ecom|jzqct=/.-; _jzqckmp=1; __zpWAM=1502703402261.368233.1502703402.1502703402.1; __zpWAMs2=1; at=1eb633b79ecd41058e9528a3491c4511; Token=1eb633b79ecd41058e9528a3491c4511; rt=c8c20e78fc7746e5a644eb240a41b9fd; uiioit=377220665963566655675566556456725D665063506655675F6627642672596657635D665067526652645B72566656635F660; xychkcontr=39567922%2c0; lastchannelurl=https%3A//passport.zhaopin.com/org/login%3FDYWE%3D1502703402261.368233.1502703402.1502703402.1%26y7bRbP%3DdpmZkUxnQvxnQvxnGbM2LVyVnv_tCi2uf.FTlkQWRUE; JsNewlogin=201049440; utype=2; ihrtkn=; cgmark=2; NewPinLoginInfo=; NewPinUserInfo=; RDpUserInfo=; isNewUser=1; FSSBBIl1UgzbN7N443S=emWOguXYECCmvvqzoRqHhRCdAdYmpwjA_bwukRkHlUeBzrhw3i93ONaQfqZ3MD4i; SearchHead_Erd=rd; Home_ResultForCustom_displayMode_nS0aerG5upOsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_3QhRSge6TYFMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_Meh-hSa9SnOsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_09XCg7Ahg4usGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ZizzL3ddSP6sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_bhyAmLhKa1esGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Yx0EU8OxZUgqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_aUe_0Okl41VMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_HSK4kTjCHLesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Bv86n97nLKmsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_XQXiEN6qruysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_nIW-Z-QnUoasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_WYDI14WmNFesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_B6NNKuwWtw5Md9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_52YcEm5-OzWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_KTgeRyfO8JJMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_f1S-PhuLKzwqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_pd7io_GhkiGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_fnww0PZH5JQ3XVmHzCaEag_1=1; Home_ResultForCustom_displayMode_geNV7rks5UqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_7ZtHTCbBU2WsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_qD0rzuLA_sesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_BpNqTzqm6g_sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_t5ymJPXU0HCsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ic-9yiLI2vysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_dHp0mjzK9TysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_uHOv95oN6zGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_v9y55nTMWxusGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Gl2clHpbkoKsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_fTaN2Ex0KWasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_pUKQlsOMYOkqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_q3MSlXpIfBysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_zW9BAjSVnoysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_y-tITf23zdGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode__SXymO8k-4msGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_UaIyfcVikPGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_G-zN97T5jh9H1C45p4a3TQ_1=1; Home_ResultForCustom_displayMode_2tAoWHkZCr43F1xwQFC3eA_1=1; Home_ResultForCustom_displayMode_eAn7fythV0esGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ByaS6Wsx616sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_jSH2NeNHN6QQnspAsGDPuA_1=1; Home_ResultForCustom_displayMode_UWPup8U_L4asGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_2Yf4c0DdeNmsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_03fEvdCV_4SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_yW21syfjhlqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_uunB_EsqPwqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_JpiAROnI26SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ETntHVk8v29Md9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_-X9piJ8My8SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_UOoJBMBnCsWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode__NQPj4mY4g6sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_FDSf7bPEsvKsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_WfOYyEvogqqsGuFOEERQfQ_1=1; RDsUserInfo=2265362C58664565547945644765462C5C664365507944644C653E2C2B664A65127906641065412C5C664265527943644E65402C576613655F79216439654F2C2B35133237E9753E4C653C2C2B664A655F79366433654F2C56664E655179426440654B2C576645655F79366439654F2C3C0B28092A2A103324F5737615031906B500F4067E0222BA09378F365F7920643A654F2C5E663265297949641F65192C0D660565247903641865002C0E6612650A795A6414651C2C5E662465307949644665492C2466236559794C645A65432C5166576555794D644D65462C5E6633652079496444654B2C5066416553794D644565402C5E6633652A7949642E082D402B35133237E9753E07001C4FB41FF7076D1E24F21B348A7F5E663B65297949644765422C556646655F79376433654F2C5366426557794F6436653E2C586647655F79216436654F2C5E663465257949643465312C56664E655179426440654B2C5766456552794F643365332C58663465277947644E65472C536640655D7946644565442C5E663365277949644765492C36663E65597947644C653B2C35664A655679406445655C2C5466466550794F642265262C58664665547945644C655; Home_ResultForCustom_displayMode_NV8kghyiFCesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_i5VDWsYaViusGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_tcijgjuJYxysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Itcw8oRxgPWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_BpAlqmkZusesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Ic0snNv4U0JMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_QhNf1IDdWkasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_E5ajMnso68KsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_R4nUgQBwjFWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ldpONIgRXxAqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_M7QvDu7WgzGsGuFOEERQfQ_1=1; Home_ResultForCustom_orderBy=DATE_MODIFIED%2C1; __utma=269921210.876377932.1498471850.1502760810.1502763030.5; __utmc=269921210; __utmz=269921210.1502703389.2.2.utmcsr=zhaopin.com|utmccn=(referral)|utmcmd=referral|utmcct=/; SearchHistory_StrategyId_1=%2fHome%2fResultForCustom%3fSF_1_1_1%3djava%26orderBy%3dDATE_MODIFIED%252c1%26SF_1_1_27%3d0%26exclude%3d1%26pageIndex%3d4; dywea=95841923.1125430013274052200.1498471850.1502705486.1502760484.4; dywec=95841923; dyweb=95841923.11.10.1502760484; Hm_lvt_38ba284938d5eddca645bb5e02a02006=1502703389; Hm_lpvt_38ba284938d5eddca645bb5e02a02006=1502764727; FSSBBIl1UgzbN7N443T=1gBRrGYnGKCKFNWR_qYhayyM7hRlNjNhcHKAGFqeC3wlRDOysXstFJ25I1_6VGYPSnRKPLRU4kVZPfyAufSoXcThHEPi8WWOXa8DMiQ2IoR9BZbTwTEzC710O7ubGEhm2ktuQAc3WYI8X36jAwgajkWplpGUPj5SpBdtnrKaCHrmO04KaqLycaP4N9I_Mn4T9kTcByLsMbNcrSdqjwpLhTlf4q1lbVgLkdGaVb68CmpXCRJr6hJVQF48M0YNnQykBQXYmZQZFRlhuuY3MuuL_3ajAzLUphAhWYEzxyD_s7KLDVNjQemyDjAId03is69PmLnL";
//        String url = "https://rdsearch.zhaopin.com/Home/ResultForCustom";
//        String url = "https://rdsearch.zhaopin.com/Home/ResultForCustom?SF_1_1_1=java&SF_1_1_18=653&SF_1_1_9=1&SF_1_1_5=5%2C16&SF_1_1_27=0&orderBy=DATE_MODIFIED,1&exclude=1";

//        String url = "https://rdsearch.zhaopin.com/Home/ResultForCustom?SF_1_1_1=java&orderBy=DATE_MODIFIED%2C1&SF_1_1_27=0&exclude=1&pageIndex=8";
//        String cookieStr = "urlfrom=121113803; urlfrom2=121113803; adfcid=pzzhubiaoti1; adfcid2=pzzhubiaoti1; adfbid=0; adfbid2=0; __xsptplus30=30.2.1502703389.1502703389.1%234%7C%7C%7C%7C%7C%23%23lfRGPMQpDTQFBiTxVY3WPyCtwMg3JiXy%23; pcc=r=961464233&t=0; _jzqa=1.1622623789528813800.1498471850.1498471850.1502703389.2; _jzqc=1; _jzqx=1.1498471850.1502703389.1.jzqsr=zhaopin%2Ecom|jzqct=/.-; _jzqckmp=1; __zpWAM=1502703402261.368233.1502703402.1502703402.1; __zpWAMs2=1; at=1eb633b79ecd41058e9528a3491c4511; Token=1eb633b79ecd41058e9528a3491c4511; rt=c8c20e78fc7746e5a644eb240a41b9fd; uiioit=377220665963566655675566556456725D665063506655675F6627642672596657635D665067526652645B72566656635F660; xychkcontr=39567922%2c0; lastchannelurl=https%3A//passport.zhaopin.com/org/login%3FDYWE%3D1502703402261.368233.1502703402.1502703402.1%26y7bRbP%3DdpmZkUxnQvxnQvxnGbM2LVyVnv_tCi2uf.FTlkQWRUE; JsNewlogin=201049440; utype=2; ihrtkn=; cgmark=2; NewPinLoginInfo=; NewPinUserInfo=; RDpUserInfo=; isNewUser=1; SearchHead_Erd=rd; Home_ResultForCustom_displayMode_nS0aerG5upOsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_3QhRSge6TYFMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_Meh-hSa9SnOsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_09XCg7Ahg4usGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ZizzL3ddSP6sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_bhyAmLhKa1esGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Yx0EU8OxZUgqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_aUe_0Okl41VMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_HSK4kTjCHLesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Bv86n97nLKmsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_XQXiEN6qruysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_nIW-Z-QnUoasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_WYDI14WmNFesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_B6NNKuwWtw5Md9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_52YcEm5-OzWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_KTgeRyfO8JJMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_f1S-PhuLKzwqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_pd7io_GhkiGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_fnww0PZH5JQ3XVmHzCaEag_1=1; Home_ResultForCustom_displayMode_geNV7rks5UqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_7ZtHTCbBU2WsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_qD0rzuLA_sesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_BpNqTzqm6g_sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_t5ymJPXU0HCsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ic-9yiLI2vysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_dHp0mjzK9TysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_uHOv95oN6zGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_v9y55nTMWxusGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Gl2clHpbkoKsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_fTaN2Ex0KWasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_pUKQlsOMYOkqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_q3MSlXpIfBysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_zW9BAjSVnoysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_y-tITf23zdGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode__SXymO8k-4msGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_UaIyfcVikPGsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_G-zN97T5jh9H1C45p4a3TQ_1=1; Home_ResultForCustom_displayMode_2tAoWHkZCr43F1xwQFC3eA_1=1; Home_ResultForCustom_displayMode_eAn7fythV0esGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ByaS6Wsx616sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_jSH2NeNHN6QQnspAsGDPuA_1=1; Home_ResultForCustom_displayMode_UWPup8U_L4asGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_2Yf4c0DdeNmsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_03fEvdCV_4SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_yW21syfjhlqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_uunB_EsqPwqsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_JpiAROnI26SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ETntHVk8v29Md9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_-X9piJ8My8SsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_UOoJBMBnCsWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode__NQPj4mY4g6sGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_FDSf7bPEsvKsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_WfOYyEvogqqsGuFOEERQfQ_1=1; RDsUserInfo=2265362C58664565547945644765462C5C664365507944644C653E2C2B664A65127906641065412C5C664265527943644E65402C576613655F79216439654F2C2B35133237E9753E4C653C2C2B664A655F79366433654F2C56664E655179426440654B2C576645655F79366439654F2C3C0B28092A2A103324F5737615031906B500F4067E0222BA09378F365F7920643A654F2C5E663265297949641F65192C0D660565247903641865002C0E6612650A795A6414651C2C5E662465307949644665492C2466236559794C645A65432C5166576555794D644D65462C5E6633652079496444654B2C5066416553794D644565402C5E6633652A7949642E082D402B35133237E9753E07001C4FB41FF7076D1E24F21B348A7F5E663B65297949644765422C556646655F79376433654F2C5366426557794F6436653E2C586647655F79216436654F2C5E663465257949643465312C56664E655179426440654B2C5766456552794F643365332C58663465277947644E65472C536640655D7946644565442C5E663365277949644765492C36663E65597947644C653B2C35664A655679406445655C2C5466466550794F642265262C58664665547945644C655; Home_ResultForCustom_displayMode_NV8kghyiFCesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_i5VDWsYaViusGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_tcijgjuJYxysGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Itcw8oRxgPWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_BpAlqmkZusesGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_Ic0snNv4U0JMd9sRRxAd9w_1=1; Home_ResultForCustom_displayMode_QhNf1IDdWkasGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_E5ajMnso68KsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_R4nUgQBwjFWsGuFOEERQfQ_1=1; Home_ResultForCustom_displayMode_ldpONIgRXxAqx2XF8JkBQw_1=1; Home_ResultForCustom_displayMode_M7QvDu7WgzGsGuFOEERQfQ_1=1; __utma=269921210.876377932.1498471850.1502763030.1502766282.6; __utmc=269921210; __utmz=269921210.1502703389.2.2.utmcsr=zhaopin.com|utmccn=(referral)|utmcmd=referral|utmcct=/; Home_ResultForCustom_orderBy=DATE_MODIFIED%2C1; FSSBBIl1UgzbN7N443S=RAIRJCYZke3HVdLtfQpqiqPHzVme7.lz6fSAFBCKR29eJZGmg2tGOJVfyYBPCVi1; SearchHistory_StrategyId_1=%2fHome%2fResultForCustom%3fSF_1_1_1%3djava%26orderBy%3dDATE_MODIFIED%252c1%26SF_1_1_27%3d0%26exclude%3d1%26pageIndex%3d7; Hm_lvt_38ba284938d5eddca645bb5e02a02006=1502703389; Hm_lpvt_38ba284938d5eddca645bb5e02a02006=1502778866; dywez=95841923.1502780800.6.3.dywecsr=rdsearch.zhaopin.com|dyweccn=(referral)|dywecmd=referral|dywectr=undefined|dywecct=/home/redirecttord/tayku9)bi6gsgufoeerqfq_1_1; dywea=95841923.1125430013274052200.1498471850.1502777396.1502780800.6; dywec=95841923; FSSBBIl1UgzbN7N443T=1Sw0uqqGDyrT5.tIrZN47R4xxwpfU6lvp7v5jGLbgqt5ThVglP3if764PU5mv0AD4K0YpoHqh02nulRCh.uFSCQccNj_4Ml9UldQmXLC3fTNBMFkh.c6yxXGGptGatI.FPf8hMKfZTCq9zPItG9TFR5l4SkKx7KEZ1nCgsZ3iDypa9UWTewglq7uue1td.K58gyGyjhmL1RcjXLfwnRbnFdyGSkGFhRTXuCrUaILehmp2WlSbtzzOVj6atm0LpimOrojYMkG_z8djQDPHybxul2R4mJiurNmLNbopuOEbHgASTbcfZ1oAm9UmhAVT3MYVQY3";

        String url = "http://192.168.0.114:8080/scheduler/manage/task/redo?taskId=98610";
        String cookieStr = "JSESSIONID=BBFB70A9EA1CEF7984C91201CE3B8AB6; Hm_lvt_765ecde8c11b85f1ac5f168fa6e6821f=1495502218; Hm_lvt_39dcd5bd05965dcfa70b1d2457c6dcae=1495502218; csrftoken=88piJA7gUmdF8Z6HTi5fn8WshtC2wdQp; sessionid=p9oa8g5rih0odya3graj2dy5bq3q8suj; __utma=179096804.1951819859.1497232850.1512698169.1512698169.65; __utmc=179096804; __utmz=179096804.1497232850.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); name=xuyang; pwd=hkdwxuyang123";


        Map<String,String> headMap = new HashMap<String,String>();
//        headMap.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        headMap.put("Accept-Encoding","gzip, deflate, sdch, br");
//        headMap.put("Accept-Language","zh-CN,zh;q=0.8");
//        headMap.put("Cache-Control","no-cache");
//        headMap.put("Connection","keep-alive");
        headMap.put("Cookie", cookieStr);
//        headMap.put("Host","rdsearch.zhaopin.com");
//        headMap.put("Pragma","no-cache");
//        headMap.put("Referer","https://rdsearch.zhaopin.com/home/SearchByCustom");
//        headMap.put("Upgrade-Insecure-Requests","1");
//        headMap.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");


        Map<String,String> paramMap = new HashMap<String,String>();
//        paramMap.put("SF_1_1_1","java");
//        paramMap.put("SF_1_1_27","0");
//        paramMap.put("orderBy","DATE_MODIFIED,1");
//        paramMap.put("exclude","1");
//        paramMap.put("pageIndex","2");
//        paramMap.put("SF_1_1_18","653");
//        paramMap.put("SF_1_1_9","1");
//        paramMap.put("SF_1_1_5","5,16");

        Map<String,String> paramMap1 = new HashMap<String,String>();
        paramMap1.put("operateBy","17");
        paramMap1.put("breakpoint","false");
        paramMap1.put("isSerialSupply","false");
        paramMap1.put("isCascadeValidateParentTask","false");
        paramMap1.put("taskId","98612");

        try {
            //TODO 此处获取51job页面乱码,其他页面正常
//            String result = HttpUtil.doProxyHttp("GET", url, paramMap, headMap, HttpURLConnection.HTTP_OK, "UTF8", "60.191.57.137", 16816);
            HttpUtil.doHTTP("POST",url,paramMap1);
            try {
//                FileUtil.writeToFile("E:\\html_fetch\\tianyancha\\", cur_time_sign, result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
//    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr){
//        JSONObject jsonObject = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
//            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
//            TrustManager[] tm = { new MyX509TrustManager() };
//            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//            sslContext.init(null, tm, new java.security.SecureRandom());
//            // 从上述SSLContext对象中得到SSLSocketFactory对象
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//            URL url = new URL(requestUrl);
//            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
//            httpUrlConn.setSSLSocketFactory(ssf);
//
//            httpUrlConn.setDoOutput(true);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//            // 设置请求方式（GET/POST）
//            httpUrlConn.setRequestMethod(requestMethod);
//
//            // if ("GET".equalsIgnoreCase(requestMethod))
//            httpUrlConn.connect();
//
//            // 当有数据需要提交时
//            if (null != outputStr) {
//                OutputStream outputStream = httpUrlConn.getOutputStream();
//                // 注意编码格式，防止中文乱码
//                outputStream.write(outputStr.getBytes("UTF-8"));
//                outputStream.close();
//            }
//
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            // 释放资源
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
//            jsonObject = JSONObject.fromObject(buffer.toString());
//        } catch (ConnectException ce) {
//            log.error("Weixin server connection timed out.");
//        } catch (Exception e) {
//            log.error("https request error:{}", e);
//        }
//        return jsonObject;
//    }


}
