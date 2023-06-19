import React, { Component, useState } from "react";
import ReactQuill, { Quill } from "react-quill";
import "react-quill/dist/quill.snow.css";


export default class Editor extends React.Component {

  constructor (props) {
    super(props)
    this.state = { editorHtml: '' }
    this.handleChange = this.handleChange.bind(this)

  }


  handleChange (html) {
  	this.setState({ editorHtml: html });
    this.props.setPost(prev => ({...prev,content : this.state.editorHtml}))
  }



  render () {
    return (
      <div style={{width : "600px", height : "600px"}}>
        <ReactQuill
          style={{width:"100%" , height: "100%"}}
          onChange={this.handleChange}
          value={this.state.editorHtml}
          modules={Editor.modules}
          formats={Editor.formats}
          bounds={'.app'}
          placeholder={"관심사를 공유해주세요"}
         />

       </div>
     )
  }
}

/*
 * Quill modules to attach to editor
 * See https://quilljs.com/docs/modules/ for complete options
 */
Editor.modules = {

  toolbar: [
    [{ 'header': '1'}, {'header': '2'}, { 'font': [] }],
    [{size: []}],
    ['bold', 'italic', 'underline', 'strike', 'blockquote'],
    [{'list': 'ordered'}, {'list': 'bullet'},
     {'indent': '-1'}, {'indent': '+1'}],
    ['link', 'image'],
    ['clean']
  ],
  clipboard: {
    // toggle to add extra line breaks when pasting HTML:
    matchVisual: false,
  }
}
/*
 * Quill editor formats
 * See https://quilljs.com/docs/formats/
 */
Editor.formats = [
  'header', 'font', 'size',
  'bold', 'italic', 'underline', 'strike', 'blockquote',
  'list', 'bullet', 'indent',
  'link', 'image'
]

