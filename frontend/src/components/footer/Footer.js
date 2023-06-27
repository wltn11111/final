import style from './Footer.module.css';

function Footer () {
  return (
    <div className={`${style.footer}`}>
      <div className={`${style.footer_t} row`} >
        <div className="col-4 footer-l">
        <ul className={`${style.footer_list} mt-3`}>
          <li><h3 style={{fontSize : "22px"}}>Bang-Guseog</h3></li>
          <li className="ml-1 mt-3">BGS INC.</li>
          <li className="ml-1">Seoul Republic of Korea | 070 5878 2939 | info@bgsmag.com</li>
        </ul>
        </div>
        <div className="col-4" style={{padding:"0px"}}></div>
        <div className="col-4 d-flex justify-content-center footer-r" style={{padding:"0px"}}>
          <div className={style.logoBox}>로고입니다</div>
        </div>
      </div>
      <div className="row" style={{margin : "0px"}}>
        <div className={`${style.copyRight} col-12 d-flex justify-content-center mt-4 mb-4 copyRight`}
        style={{padding:"0px"}}>
        COPYRIGHT © BangGuseog ALL RIGHTS RESERVED / SITE BY 42KH
        </div>
      </div>
    </div>

  )
}

export default Footer;
