
//Success:
// 		Runtime:4 ms, faster than 74.55% of Rust online submissions.
// 		Memory Usage:2.1 MB, less than 55.00% of Rust online submissions.
pub fn convert(s: String, num_rows: i32) -> String {

    let s_len = s.len() as i32;


    if num_rows <= 1 || s_len <= 2 {
        return s;
    }

    let cycle_len = (2 * num_rows - 2); // 一个完整循环数
    let ss: Vec<char> = s.chars().collect();
    let mut str = String::new();

    for row in 0..num_rows {
        let mut i = 0;
        while i + row < s_len {
            str.push(ss[(i + row) as usize]);

            if row != 0 && row != num_rows - 1 {
                let target = i + cycle_len - row;
                if target < s_len { str.push(ss[target as usize]); }

            }

            i += cycle_len;
        }
    }

    return str;
}

#[test]
fn main()  {
    let string = convert(String::from("ABCD"), 3);
    println!("correct: ABDC");
    println!("{}",string)
}