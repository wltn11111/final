import 'bootstrap/dist/css/bootstrap.min.css';
import style from './Reply.module.css'
import { useState } from 'react';
import profile from '../../../assets/images/reply_profile.jpg'

const Btn = ({ replyView, setReplyView }) => {
  return (
    <div className={style.btn_container}>
      <div style={{ float: "left", marginRight: "10px" }}>
        <button className={style.reply_btn}
          onClick={() => { setReplyView(!replyView) }}>
          <i className="ri-message-3-line me-1"></i>
          댓글
        </button>
      </div>
      <div>
        <button className={style.reply_btn}>
          북마크
        </button>
      </div>
    </div>
  )
}

const Reply = ({ replys, setReplys }) => {
  const [reply, setReply] = useState({});
  const handleChange = (e) => {
    const {name,value} = e.target
    setReply({ [name]: value })
  }

  return (
    <div className={style.reply_list}>
      {replys != null ? <ReplyList replys={replys}></ReplyList> : null}
      <div className={style.reply_container}>
        <div><strong>댓글</strong></div>
        <div><textarea className={style.reply_input} name='reply'
          onChange={handleChange}></textarea></div>
        <div className={style.submit_btn_box}>
          <button className={style.submit_btn} onClick={() => {
            setReplys(prev => [...prev, reply])
          }}>확인</button>
        </div>
      </div>
    </div>
  )
}

const ReplyList = ({ replys,setReplys }) => {
  return (
    <>
      {
        replys.map((reply, i) => {
          return (
            <>
              <Comment
                reply={reply}
                replys={replys}
                setReplys={setReplys}
              >
              </Comment>
            </>
          )
        })
      }
    </>
  )
}

const Comment = ({ reply, setReplys, replys }) => {
  const [recommentView, setRecommentView] = useState(false);
  const [replyMod, setReplyMod] = useState(false);
  return (
    <>
      <div className={style.replys}>
        <div className={style.profile_box}>
          <div className={style.profile}>
            <img src = {profile} style={{width : "100%" , height : "100%"}}></img>
          </div>
        </div>
        <div className={style.reply_content}>
          <div className={style.content_t}>
            <div className={style.user_info}>username</div>
            <div className={style.mod_btn}>
              <ul className={style.ul}>
                <li className={style.li} onClick={() => {
                  setReplyMod(!replyMod);
                }}>수정</li>
                <li className={style.li}>삭제</li>
              </ul>
            </div>
            <div className={style.recomment}>
              <span
                onClick={(e) => {
                  setRecommentView(!recommentView)
                }}>댓글 달기</span></div>
          </div>
          {replyMod ? <ReplyMod setReplyMod={setReplyMod}
            replys={replys} ></ReplyMod> :
            <div className={style.content_b}>
              {reply.reply}
            </div>
          }
        </div>
      </div>
      <Recomment_list></Recomment_list>
      {recommentView ? <Recomment setRecommentView = {setRecommentView}></Recomment> : null}

    </>
  )
}

const ReplyMod = ({ setReplyMod, setReplys, replys }) => {
  return (
    <div className={style.replymod_container}>
      <div className={style.replymod_title}><strong>댓글수정</strong></div>
      <div><textarea className={style.replymod_input}
      ></textarea></div>
      <div className={style.submit_btn_box}>
        <button className={style.submit_btn}
          onClick={{}}
        >수정</button>
        <button className={style.cancel_btn}
          onClick={() => {
            setReplyMod(false);
          }}
        >수정 취소</button>
      </div>
    </div>
  )
}

const Recomment = ({ setRecommentView }) => {
  return (
    <div className={style.recomment_container}>
      <div><i className="ri-corner-down-right-line"></i>댓글</div>
      <div><textarea className={style.recomment_input}
      ></textarea></div>
      <div className={style.submit_btn_box}>
        <button className={style.submit_btn}>확인</button>
        <button className={style.submit_btn}
          onClick={() => {
            setRecommentView(false)
          }}>취소</button>
      </div>
    </div>
  )
}


const Recomment_list = () => {
  return (
    <div className={style.replys} style={{ margin: "0px", borderTop : "none" }}>
      <div className={style.icon_box}>
        <i className="ri-corner-down-right-line"></i>
      </div>
      <div className={`${style.reply_content} mt-1`}>
        <div className={style.content_t}>
          <div className={style.user_info}>username</div>
          <div className={style.mod_btn}>
            <ul className={style.ul}>
              <li className={style.li}>수정</li>
              <li className={style.li}>삭제</li>
            </ul>
          </div>
        </div>
        <div>
          대댓글 영역입니다.
        </div>
      </div>


    </div>
  )
}

export default function ({ replys, setReplys }) {
  const [replyView, setReplyView] = useState(false);

  return (
    <>
      <Btn replyView={replyView} setReplyView={setReplyView}></Btn>
      {replyView ? <Reply replys={replys} setReplys={setReplys}></Reply> : null}
    </>
  )
}
