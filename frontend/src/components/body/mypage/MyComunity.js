import 'bootstrap/dist/css/bootstrap.css';
import style from './MyComunity.module.css'
import { Pagination } from 'react-js-pagination'
import { useState } from 'react';
import { Nav } from 'react-bootstrap';

export default function () {

  const[tab,setTab] = useState(0);

  return (
    <div className={style.container}>
      <div>
        <Nav variant="tabs" defaultActiveKey="link0" >
          <Nav.Item style={{width : "45%"}} className={style.nav}>
            <Nav.Link eventKey="link0"  onClick={() => {
              setTab(0);
            }}><span className={style.navi_item}>작성글</span></Nav.Link>
          </Nav.Item>
          <Nav.Item style={{width : "45%"}} className={style.nav}>
            <Nav.Link eventKey="link1" onClick={() => {
              setTab(1);
            }}><span className={style.navi_item}>작성 댓글 </span></Nav.Link>
          </Nav.Item>
        </Nav>
      </div>
      <Tab tab={tab}></Tab>
    </div>
  )
}

const Post = () => {
  return (
    <div className={style.post_box}>
      <div className={style.title}><strong>제목</strong></div>
      <div className={style.post_list}>제목입니다</div>
      <div className={style.post_list}>제목입니다</div>
      <div className={style.post_list}>제목입니다</div>
    </div>
  )
}

const Reply = () => {
  return (
    <div className={style.reply_box}>
      <div className={style.title}><strong>댓글</strong></div>
      <div className={style.reply}>
        댓글입니다
      </div>
      <div className={style.reply}>
       <p className={style.reply_p}>
        </p>
      </div>
      <div className={style.reply}>
       <p></p>
      </div>
    </div>
  )
}


function Tab(props) {

  return (
    <div>
      {[<Post></Post>,
      <Reply></Reply>][props.tab]}
    </div>
  )
}