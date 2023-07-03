import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import {useEffect, useRef, useState} from "react";
import {Link} from 'react-router-dom';

export default function List({posts, page, setPage, search}) {

  const [item, setItem] = useState([]);
  const pageEnd = useRef();
  const [loading, setLoading] = useState(false);


  const getItem = (page) => {


    if (search.category == 'ALL' && search.word == '') {
      setItem(posts.slice(0, page));
      return
    }

    const item = posts.filter(post => post.category == search.category || search.category == "ALL")
      .filter(post => post.title.includes(search.word) || post.contents.includes(search.word))
    setItem(item);
  }

  useEffect(() => {
    console.log(posts)
    getItem(page);
    setLoading(true);
  }, [page])

  useEffect(() => {
    getItem(page);
    setLoading(true);
  }, [search])


  const loadMore = () => {
    setPage(prev => prev + 3);
  }

  useEffect(() => {
    if (loading) {
      const observer = new IntersectionObserver((entries, observer) => {
        loadMore();
      })
      observer.observe(pageEnd.current);
    }
  }, [loading])

  return (
    <div className={`${style.container}`}>
      {item.map((post, i) => {
        return (
          <>
            <div>
              <Link to={`/post/${post.id}`} state={{from: post}}>
                <div className={`${style.content} mt-4`}
                     key={i}>
                  <div className={`${style.content_box} mt-4`}>
                    <div className={`${style.title} d-flex justify-content-start mt-3`}>
                      <strong>{post.title}</strong>
                    </div>
                    <div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
                      <p dangerouslySetInnerHTML={{__html: post.contents}}>
                      </p>
                    </div>
                    <div className={`${style.content_info} d-flex justify-content-start`}>
                      <div className={style.like_box}>
                        좋아요 정보 박스 •
                      </div>
                      <div className={style.author_box}>
                        by {post.author} •
                      </div>
                    </div>
                  </div>
                </div>
              </Link>
            </div>
          </>
        )
      })}
      <div ref={pageEnd}/>
    </div>
  )
}