-------------------------------------------------------------------------------
-- Opcode package
-------------------------------------------------------------------------------
library IEEE;
use IEEE.Std_Logic_1164.all;

package opcodes_stream_out_stream_out_status_V3 is

  constant STREAM_OUT_V3        : std_logic_vector(1-1 downto 0) := "1";
  constant STREAM_OUT_STATUS_V3 : std_logic_vector(1-1 downto 0) := "0";
  
end opcodes_stream_out_stream_out_status_V3;

-------------------------------------------------------------------------------
-- Stream out unit
-------------------------------------------------------------------------------
library IEEE;
use IEEE.Std_Logic_1164.all;
use IEEE.numeric_std.all;
use work.opcodes_stream_out_stream_out_status_V3.all;

entity stream_out_stream_out_status_V3 is
  
  generic (
    busw : integer := 8);

  port (
    t1data   : in  std_logic_vector(31 downto 0);
    t1load   : in  std_logic;
    t1opcode : in  std_logic_vector(1-1 downto 0);
    r1data   : out std_logic_vector(31 downto 0);
    clk      : in  std_logic;
    rstx     : in  std_logic;
    glock    : in  std_logic;

    -- external interface
    ext_data   : out std_logic_vector(31 downto 0);  -- the actual data to stream out
    ext_status : in  std_logic_vector(8 downto 0);  -- status signal from outside
    ext_dv     : out std_logic_vector(0 downto 0) -- datavalid signal
    );

end stream_out_stream_out_status_V3;


architecture rtl of stream_out_stream_out_status_V3 is
  signal r1reg   : std_logic_vector(31 downto 0);
  signal datareg : std_logic_vector(31 downto 0);
  signal dvreg   : std_logic_vector(0 downto 0);

begin
  
  regs : process (clk, rstx)
  begin  -- process regs
    if rstx = '0' then
      datareg <= (others => '0');
      dvreg   <= (others => '0');
    elsif clk'event and clk = '1' then
      if glock = '0' then

        -- reset the datavalid signal
        dvreg <= (others => '0');

        if t1load = '1' then
          case t1opcode is
            when STREAM_OUT_V3 =>
              datareg <= t1data;
              dvreg   <= (0 => '1', others => '0');
              -- enable the datavalid signal for a while
--            when STREAM_OUT_STATUS_V3 =>
--              r1reg <= (0 => ext_status(0), 1 => ext_status(1), 2 => ext_status(2), 3 => ext_status(3), 4 => ext_status(4), 5 => ext_status(5), 6 => ext_status(6), 7 => ext_status(7), 8 => ext_status(8), others => '0');
              -- make the stream_out_status visible in the lsb
            when others => null;
          end case;
        end if;

      end if;
    end if;
  end process regs;

  --r1data  <= r1reg;
  r1data   <= (0 => ext_status(0), 1 => ext_status(1), 2 => ext_status(2), 3 => ext_status(3), 4 => ext_status(4), 5 => ext_status(5), 6 => ext_status(6), 7 => ext_status(7), 8 => ext_status(8), others => '0');
  ext_data <= datareg;
  ext_dv   <= dvreg;
  
end rtl;
