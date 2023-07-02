import 'bootstrap/dist/css/bootstrap.min.css';
import style from './Reply.module.css'
import { useEffect, useState } from 'react';
import profile from '../../../assets/images/reply_profile.jpg'
import axios from 'axios';


const Btn = ({ replyView, setReplyView, post_id, replys, setLiked, liked, bookMarked, setBookMarked }) => {

  const likeHandle = async () => {
    if (liked.isLike) {
      try {
        await axios.delete(`/api/v1/likes/posts/${post_id}`).then((resp) => {
          setLiked({ isLike: resp.data.isLike, count: resp.data.count })
        })
      } catch (err) {
        console.log("like delete err : " + err)
      }
    } else {
      try {
        await axios.post(`/api/v1/likes/posts/${post_id}`).then((resp) => {
          setLiked({ isLike: resp.data.isLike, count: resp.data.count })
        })
      } catch (err) {
        console.log("like post err : " + err)
      }
    }
  }

  const bookMarkHandle = async () => {
    if (bookMarked.isSubscribed) {
      try {
        await axios.delete(`/api/v1/bookmarks/${post_id}`).then(() => {
          setBookMarked(false)
        })
      } catch (err) {
        console.log(err)
      }
    } else {
      try {
        await axios.post(`/api/v1/bookmarks/${post_id}`).then((resp) => {
          setBookMarked(true)
        })
      } catch (err) {
        console.log(err)
      }
    }
  }

  return (
    <div className={style.btn_container}>
      <div style={{ float: "left", marginRight: "10px" }}>
        <button className={style.reply_btn}
          onClick={() => { setReplyView(!replyView) }}>
          <i className="ri-message-3-line me-1"></i>
          댓글 <span style={{ fontSize: "14px" }}>{replys.length}</span>
        </button>
      </div>
      <div style={{ float: "left", marginRight: "10px" }}>
        <button className={style.bookmark_btn}
          onClick={bookMarkHandle}>
          <i className="ri-bookmark-fill" style={{ color: bookMarked ? "#FFD228" : "grey", transitionDuration: "1s" }}></i>
          북마크
        </button>
      </div>
      <div>
        <button className={style.like_btn}
          onClick={likeHandle}>
          <i className="ri-heart-3-fill me-1 like_i" style={{
            color: liked.isLike ? "#9B111E" : "grey",
            transitionDuration: "1s"
          }}
          ></i>
          좋아요 {liked.count}
        </button>
      </div>
    </div>
  )
}

const Reply = ({ replys, setReplys, post_id , user }) => {


  const [reply, setReply] = useState({ contents: "" });
  const handleChange = (e) => {
    const { name, value } = e.target
    setReply(prev => ({ ...prev, [name]: value }))
  }

  const sendReply = async () => {
    if (reply.contents == "") {
      alert("댓글을 입력해주세요")
      return;
    }
    axios({
      method: "post",
      url: `/api/v1/comments/${post_id}`,
      data: reply
    }).then((resp) => {
      setReplys(prev => [...prev, resp.data])
      setReply(prev => ({...prev,contents: "" }));
    })
  }

  return (
    <div className={style.reply_list}>
      {replys != null ? <ReplyList replys={replys} setReplys={setReplys} id = {post_id}></ReplyList> : null}
      <div className={style.reply_container}>
        <div><strong>댓글</strong></div>
        <div><textarea className={style.reply_input} name='contents'
          onChange={handleChange} value={reply.contents}></textarea></div>
        <div className={style.submit_btn_box}>
          <button className={style.submit_btn} onClick={sendReply}>확인</button>
        </div>
      </div>
    </div>
  )
}

const ReplyList = ({ replys, setReplys }) => {

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
  const [replyModView, setReplyModView] = useState(false);

  const delReply = async () => {
    if (window.confirm('정말 삭제하시겠습니까?')) {
      await axios.delete(`/api/v1/comments/${reply.id}`)
      setReplys(replys.filter((e) => (e.id !== reply.id)))
    }
  }

  return (
    <div className>
      <div className={style.replys}>
        <div className={style.profile_box}>
          <div className={style.profile}>
            <img src={profile} style={{ width: "100%", height: "100%" }}></img>
          </div>
        </div>
        <div className={style.reply_content}>
          <div className={style.content_t}>
            <div className={style.user_info}>
              <span>{reply.author}</span>
              <span className={style.reply_like}>
                <i className={`${style.like_i} ri-chat-heart-line me-1`} />
                like_count
              </span>
            </div>
            <div className={style.mod_btn}>
              <ul className={style.ul}>
                <li className={style.li} onClick={() => {
                  setReplyModView(!replyModView);
                }}>수정</li>
                <li className={style.li} onClick={delReply}>삭제</li>
              </ul>
            </div>
            <div className={style.recomment}>
              <span
                onClick={(e) => {
                  setRecommentView(!recommentView)
                }}>댓글 달기</span></div>
          </div>
          {replyModView ? <ReplyMod setReplyModView={setReplyModView}
            replys={replys} reply={reply} setReplys={setReplys} ></ReplyMod> :
            <div className={style.content_b}>
              {reply.contents}
            </div>
          }
        </div>
      </div>
      <Recomment_list></Recomment_list>
      {recommentView ? <Recomment setRecommentView={setRecommentView}></Recomment> : null}
    </div>
  )
}


const ReplyMod = ({ setReplyModView, setReplys, reply, replys }) => {
  const [modReply, setModReply] = useState({});
  const handleChange = (e) => {
    const { name, value } = e.target
    setModReply({ [name]: value })
  }

  const Modreply = async () => {
    if (modReply.contents == null) {
      alert("댓글을 입력해주세요")
      return;
    }
    try {
      await axios({
        method: 'put',
        url: `/api/v1/comments/${reply.id}`,
        data: modReply
      }).then((resp) => {
        let copy = [...replys];
        let findIndex = replys.findIndex(e => e.id == reply.id);
        let sendModReply = ({ id: reply.id, contents: resp.data.contents });
        copy[findIndex] = sendModReply;
        setReplys(copy);
        setReplyModView(false);
      })
    } catch (err) {
      console.log(err)
    }
  }

  return (
    <div className={style.replymod_container}>
      <div className={style.replymod_title}
      ><strong>댓글수정</strong></div>
      <div><textarea className={style.replymod_input}
        name='contents'
        onChange={handleChange}></textarea></div>
      <div className={style.submit_btn_box}>
        <button className={style.submit_btn}
          onClick={Modreply}
        >수정</button>
        <button className={style.cancel_btn}
          onClick={() => {
            setReplyModView(false);
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
    <div className={style.replys} style={{ margin: "0px", borderTop: "none" }}>
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

export default function ({ replys, setReplys, id, liked, setLiked, bookMarked, setBookMarked , user , setTest}) {
  const [replyView, setReplyView] = useState(false);

  useEffect(()=> {
    setTest('test')
  })

  return (
    <>
      <Btn replyView={replyView} setReplyView={setReplyView} post_id={id}
        replys={replys} liked={liked} setLiked={setLiked} bookMarked={bookMarked}
        setBookMarked={setBookMarked} ></Btn>
      {replyView ?
        <Reply replys={replys} setReplys={setReplys} post_id={id}
        user = {user}>
        </Reply>
        : null}
    </>
  )
}
