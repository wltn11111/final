import 'bootstrap/dist/css/bootstrap.css';
import style from './MyComunity.module.css'
import { useEffect, useState } from 'react';
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
  // tab state는 부모인 detail 컴포넌트 안에 있어서 prop으로 전송해줘야한다
  // let [effect, setEffect] = useState('');

  // 탭 전환 효과 적용
  // useEffect(() => {
  //   setTimeout(() => { setEffect('end') }, 100)
  //   return (() => {
  //     setEffect('');
  //   })
  // }, [props.tab])
  return (
    // <div className={`start ${effect}`}>
    <div>
      {[<Post></Post>,
      <Reply></Reply>][props.tab]}
    </div>
  )
}