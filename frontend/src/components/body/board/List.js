import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import { useState, useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import { useRef } from 'react';

export default function List({ posts, page, setPage }) {

  const [item, setItem] = useState([]);
  const pageEnd = useRef();
  const [loading, setLoading] = useState(false);


  const getItem = (page) => {
    setItem(posts.slice(0, page))
  }

  useEffect(() => {
    getItem(page);
    console.log(item)
    setLoading(true);
  }, [page])


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

  // useEffect(() => {
  //   if (loading) {
  //     console.log("test2");
  //     const observer = new IntersectionObserver(
  //       entries => {
  //         if (entries[0].isIntersecting) {
  //           console.log("test3")
  //           loadMore();
  //         }
  //       },
  //       { threshold: 1 }
  //     );
  //     observer.observe(pageEnd.current);
  //   }
  // }, [loading])


  return (
    <div className={`${style.container}`}>
      {item.map((post, i) => {
        return (
          <>
            <div>
              <Link to={`/post/${post.id}`} state={{ from: post }}>
                <div className={`${style.content} mt-4`}
                  key={i}>
                  <div className={`${style.content_box} mt-4`}>
                    <div className={`${style.title} d-flex justify-content-start mt-3`}>
                      <strong>{post.title}</strong>
                    </div>
                    <div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
                      <p dangerouslySetInnerHTML={{ __html: post.contents }}>
                      </p>
                    </div>
                    <div className={`${style.content_info} d-flex justify-content-start`} >
                      <div className={style.like_box}>
                        좋아요 정보 박스 •
                      </div>
                      <div className={style.author_box}>
                        by author 정보 •
                      </div>
                    </div>
                  </div>
                </div>
              </Link>
            </div>
          </>
        )
      })}
      <div ref={pageEnd} />
    </div>
  )
}